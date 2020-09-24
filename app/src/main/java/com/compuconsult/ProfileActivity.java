package com.compuconsult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.compuconsult.app.enquete2020.MainActivity;
import com.compuconsult.app.enquete2020.R;
import com.compuconsult.app.enquete2020.database.AppDatabase;
import com.compuconsult.app.enquete2020.database.AppExecutors;
import com.compuconsult.app.enquete2020.entity.User;

public class ProfileActivity extends AppCompatActivity {

    EditText editfirstname;
    EditText editLastname;
    Button btnsubmit;
    private AppDatabase mDb;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editfirstname = (EditText) findViewById(R.id.editfirstname);
        editLastname = (EditText) findViewById(R.id.editlastname);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

    }

    private void submit() {
        if(editLastname.getText() != null && editLastname.getText().toString().isEmpty() ){
            editLastname.setError("Ce champ est obigatoire !");
        }  else if(editfirstname.getText() != null && editfirstname.getText().toString().isEmpty() ){
            editfirstname.setError("Ce champ est obigatoire !");
        }else {
            mDb = AppDatabase.getInstance(this);
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    user = new User(editLastname.getText().toString(), editfirstname.getText().toString());
                    mDb.personDao().insertUser(user);
                    startActivity(new Intent(ProfileActivity.this, MainActivity.class));

                }
            });
        }

    }
}