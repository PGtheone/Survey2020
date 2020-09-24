package com.compuconsult.app.enquete2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.compuconsult.ProfileActivity;
import com.compuconsult.app.enquete2020.CustomView.NonSwipeableViewPager;
import com.compuconsult.app.enquete2020.Utils.CSVWriter;
import com.compuconsult.app.enquete2020.adapter.QuestionnaireAdapter;
import com.compuconsult.app.enquete2020.database.AppDatabase;
import com.compuconsult.app.enquete2020.database.AppExecutors;
import com.compuconsult.app.enquete2020.entity.EAnswer;
import com.compuconsult.app.enquete2020.entity.EQuestion;
import com.compuconsult.app.enquete2020.entity.User;
import com.compuconsult.app.enquete2020.fragment.QuestionnaireFragment;
import com.compuconsult.app.enquete2020.model.Answer;
import com.compuconsult.app.enquete2020.model.Question;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements QuestionnaireFragment.OnQuestionnaireListener {

    String TYPE_EXAM_PARAM = "param_exam_type";

    NonSwipeableViewPager nonSwipeableViewPager;
    Button btnnext;
    Button previous;
    TextView txtstep;
    QuestionnaireAdapter questionnaireAdapter;
    ImageView imgback;
    private AppDatabase mDb;

    private List<Question> questionList;
    private List<Answer> answerList;
    private List<Question> userQuestionList;
    List<User> userList;

    private final int  REQUEST_CODE = 1;
    private final String AUTHORITY = "com.compuconsult.app.enquete2020.provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDb = AppDatabase.getInstance(this);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if(mDb.personDao().loadAlluser() == null || mDb.personDao().loadAlluser().isEmpty() ){
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                }else{
                    userList = mDb.personDao().loadAlluser();
                }
            }
        });

        userQuestionList = new ArrayList<>();
        initUI();
        initQuestion();
    }

    public void initQuestion(){
        Dummy dummy = new Dummy();
        questionList = dummy.getQuestions();
        FragmentManager fm = getSupportFragmentManager();
        questionnaireAdapter = new QuestionnaireAdapter(fm, questionList);
        nonSwipeableViewPager.setAdapter(questionnaireAdapter);

    }

    public void initUI(){

        nonSwipeableViewPager = findViewById(R.id.nonSwipeableViewPager);
        btnnext = findViewById(R.id.btnnext);
        previous = findViewById(R.id.btnprevious);
        txtstep = findViewById(R.id.txtstep);
//

//        imgback.setOnClickListener(c ->
//        {
//            onBackPressed();
//        });


    }

    @Override
    public void onNextPageSelected(final Question mQuestion) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
               final long id =  mDb.questionDao().insertQuestion(new EQuestion(mQuestion.getQuestion()));
                Log.d("TAG_INSERT", "Question "+mQuestion.getQuestion());
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        for(Answer a: mQuestion.getAnswerList()){
                            Log.d("TAG_INSERT", "Answer "+a.getReponse());
                            mDb.answerDao().insertAnswer(new EAnswer(a.getId(), id, a.getReponse()));
                        }
                    }
                });
            }
        });
        userQuestionList.add(mQuestion);
        nonSwipeableViewPager.setCurrentItem(nonSwipeableViewPager.getCurrentItem() + 1);
    }

    @Override
    public void onPreviousSelected(Question mQuestion) {
        userQuestionList.remove(mQuestion);
        nonSwipeableViewPager.setCurrentItem(nonSwipeableViewPager.getCurrentItem() - 1);

    }

    @Override
    public void OnSendClick(final Question mQuestion) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final long id =  mDb.questionDao().insertQuestion(new EQuestion(mQuestion.getQuestion()));
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        for(Answer a: mQuestion.getAnswerList()){
                            mDb.answerDao().insertAnswer(new EAnswer(a.getId(), id, a.getReponse()));
                        }
                    }
                });
            }
        });
        userQuestionList.add(mQuestion);
//        for(final Question question_toInsert: userQuestionList){
//            EQuestion eQuestion = new EQuestion(question_toInsert.getQuestion());
//            AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                   long id =  mDb.questionDao().insertQuestion(eQuestion);
//                   for (Answer answer_toinsert: question_toInsert.getAnswerList()){
//                       EAnswer eAnswer = new EAnswer(answer_toinsert.getId(), id, answer_toinsert.getReponse());
//                       AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                           @Override
//                           public void run() {
//                               mDb.answerDao().insertAnswer(eAnswer);
//                           }
//                       });
//                   }
//
//                }
//            });
//        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        ){
            new ExportDatabaseCSVTask().execute();
           // ShareFile();

        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);

        }

        startActivity(new Intent(MainActivity.this, MainActivity.class));

    }

//
//    private void ShareFile() {
//
//        File exportDir = new File(Environment.getExternalStorageDirectory(), "/enquete/");
//        if(!exportDir.exists()){
//            return;
//        }
//        User user = userList.get(0);
//        String fileName = "enquete2020"+user.getFirstName()+"_"+user.getLastName()+".csv";
//        File sharingGifFile = new File(exportDir, fileName);
//        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
//        shareIntent.setType("application/csv");
//        Uri uri;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//             uri = FileProvider.getUriForFile(getApplicationContext(), AUTHORITY, sharingGifFile);
//           //  uri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".provider", sharingGifFile);
////            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
////
////            ShareCompat.IntentBuilder intentBuilder = ShareCompat.IntentBuilder.from(this)
////                    .setType("application/csv")
////                    .addStream(uri);
////            Intent chooserIntent = intentBuilder.createChooserIntent();
//
////            startActivity(chooserIntent);
//
////
////            Intent shareIntents = new Intent();
////            shareIntents.setAction(Intent.ACTION_SEND);
////            shareIntents.putExtra(Intent.EXTRA_STREAM, uri);
////            shareIntents.setType("application/csv");
////            shareIntents.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
////            startActivity(Intent.createChooser(shareIntent, "  "));
//
//
//            String email = "petersontheoutsider92@gmail.com";
//            String subject = "lorem ipsum";
//            String message = "Lorem Ipsum";
//            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//            List<ResolveInfo> resInfoList = getApplicationContext().getPackageManager().queryIntentActivities(emailIntent, PackageManager.MATCH_DEFAULT_ONLY);
//            for (ResolveInfo resolveInfo : resInfoList) {
//                String packageName = resolveInfo.activityInfo.packageName;
//                getApplicationContext().grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            }
//            emailIntent.setType("plain/text");
//            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { email });
//            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,subject);
//            if (uri != null) {
//                emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
//            }
//
//            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
//            this.startActivity(Intent.createChooser(emailIntent,"Sending email..."));
//
//        }else{
//             uri = Uri.fromFile(sharingGifFile);
//            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
//            startActivity(Intent.createChooser(shareIntent, "Share CSV"));
//        }
//
//
//
//
//    }

//    public void sendEmail()
//    {
//        try
//        {
//            String email = "petersontheoutsider92@gmail.com";
//            String subject = "lorem ipsum";
//            String message = "Lorem Ipsum";
//            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//            emailIntent.setType("plain/text");
//            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { email });
//            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,subject);
//            if (URI != null) {
//                emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
//            }
//            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
//            this.startActivity(Intent.createChooser(emailIntent,"Sending email..."));
//        }
//        catch (Throwable t)
//        {
//            Toast.makeText(this, "Request failed try again: " + t.toString(),Toast.LENGTH_LONG).show();
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                new ExportDatabaseCSVTask().execute();
                //ShareFile();
            }else{
                Toast.makeText(this,"L'application doit avoir ces permissions pour partager le fichier !",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.menu_share:
                //ShareFile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class ExportDatabaseCSVTask extends AsyncTask<String, Void, Boolean> {
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        private AppDatabase appDatabase;
        @Override
        protected void onPreExecute() {
            appDatabase = AppDatabase.getInstance(getApplicationContext());
            this.dialog.setMessage("Exporting database...");
            this.dialog.show();
        }


        @Override
        protected Boolean doInBackground(String... strings) {
            this.dialog.show();
            File exportDir = new File(Environment.getExternalStorageDirectory(), "/enquete/");
            if (!exportDir.exists()) { exportDir.mkdirs(); }

            File file = new File(exportDir, "enquete2020.csv");
            try {
                file.createNewFile();
                CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
                Cursor curCSV = appDatabase.answerDao().loadAnswer();

               // Cursor curCSV = dbhelper.raw();
                csvWrite.writeNext(curCSV.getColumnNames());
                while(curCSV.moveToNext()) {
                    String arrStr[]=null;
                    String[] mySecondStringArray = new String[curCSV.getColumnNames().length];
                    for(int i=0;i<curCSV.getColumnNames().length;i++)
                    {
                        mySecondStringArray[i] =curCSV.getString(i);
                    }
                    csvWrite.writeNext(mySecondStringArray);
                }
                csvWrite.close();
                curCSV.close();
                return true;
            } catch (IOException e) {
                Log.d("TAG_EXPORT", "fail "+ e.getMessage());
                return false;
            }
        }

        protected void onPostExecute(final Boolean success) {
            if (this.dialog.isShowing()) { this.dialog.dismiss(); }
        }




    }
}