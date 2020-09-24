package com.compuconsult.app.enquete2020.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.compuconsult.app.enquete2020.R;
import com.compuconsult.app.enquete2020.model.Answer;
import com.compuconsult.app.enquete2020.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireFragment extends Fragment {

    private static final String ARG_PARAM_QUESTION = "question";
    private static final String ARG_PARAM_POSITION = "position";
    private Question mQuestion;
    private int mPosition;
    private Question userQuestion;
    List<Answer> userAnswer;

    private View view;
    private LinearLayout linearLayout;

    Button btnnext;
    Button previous;
    TextView txtstep;
    RadioGroup radioGroup;
    CheckBox checkBox;
    ImageView imgsend;
    TextView txttitre;
    int count = 0;

    // define listener in fragment
    OnQuestionnaireListener mOnQuestionnaireListener;


    public QuestionnaireFragment() {
        // Required empty public constructor
    }


    public static QuestionnaireFragment newInstance(Question question, int position) {
        QuestionnaireFragment fragment = new QuestionnaireFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM_QUESTION, question);
        args.putInt(ARG_PARAM_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mQuestion = getArguments().getParcelable(ARG_PARAM_QUESTION);
            mPosition = getArguments().getInt(ARG_PARAM_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_questionnaire, container, false);

        linearLayout = (LinearLayout) view.findViewById(R.id.content);
        btnnext = view.findViewById(R.id.btnnext);
        previous = view.findViewById(R.id.btnprevious);
        imgsend = view.findViewById(R.id.imgsend);
        txttitre = view.findViewById(R.id.txttitle);

        txtstep = view.findViewById(R.id.txtstep);
        txtstep.setText((mPosition+1) + " / 25");
        txttitre.setText("questions");
        txttitre.setText(mQuestion.getQuestion());
         if(!mQuestion.isMultiple_choix()){
             createRadioAnswer( mQuestion.getAnswerList());

         }else{
             createCheckAnswer(mQuestion.getAnswerList());
        }

        if (mPosition == 24) {
            btnnext.setVisibility(View.GONE);
            imgsend.setVisibility(View.VISIBLE);
        } else {
            btnnext.setVisibility(View.VISIBLE);
        }

        if (mPosition == 0) {
            previous.setVisibility(View.GONE);
        } else {
            previous.setVisibility(View.VISIBLE);
        }

        btnnext.setOnClickListener(c -> {
            userQuestion = getmQuestion();
            if(userQuestion!= null){
                mOnQuestionnaireListener.onNextPageSelected(userQuestion);
            }else {
                createDialog("Vous devez au moins choisir une réponse");
            }

        });


        previous.setOnClickListener(c -> {
            mOnQuestionnaireListener.onPreviousSelected(userQuestion);
        });

        imgsend.setOnClickListener(c -> {
            if(mPosition < 24){
                createDialog("Vous devez finir le questionnaire avant de le soumettre ");
            }else{

                mOnQuestionnaireListener.OnSendClick(mQuestion);
            }
        });


        return view;
    }

    private void createDialog(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void createRadioAnswer(List<Answer> answers){
        RadioButton radioButton;
        radioGroup = new RadioGroup(getContext());
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        int position = 0;
        for (Answer ans: answers) {

            radioButton = (RadioButton) getLayoutInflater().inflate(R.layout.answer, linearLayout, false);
            radioButton.setText(ans.getReponse());
            radioButton.setId(position);
            radioGroup.addView(radioButton);
            position ++;
        }
        radioGroup.check(0);
        userAnswer = new ArrayList<>();
        userAnswer.add(answers.get(0));

        linearLayout.addView(radioGroup, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        userQuestion = new Question(mQuestion.getId(), mQuestion.getQuestion(), mQuestion.isMultiple_choix());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                //RadioButton radioBtn = (RadioButton) radioGroup.findViewById(checkedRadioButtonId);
                userAnswer.set(0,answers.get(checkedRadioButtonId));
            }
        });
    }

    public void createCheckAnswer(List<Answer> answers){
        int position = 0;
        userAnswer = new ArrayList<>();
        for (Answer ans: answers) {
            checkBox = new CheckBox(getContext());
            checkBox.setId(position);
            checkBox.setText(ans.getReponse());
            linearLayout.addView(checkBox, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            position ++;
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.d("TAG_QUESTION", "Id "+compoundButton.getId()+ " "+b);
                    if(b){
                      userAnswer.add(answers.get(compoundButton.getId()));
                      count++;
                    }else{
                        userAnswer.remove(answers.get(compoundButton.getId()));
                        count--;
                    }
                }
            });
        }
    }



    public Question getmQuestion() {
        userQuestion = new Question(mQuestion.getId(), mQuestion.getQuestion(), mQuestion.isMultiple_choix());
        userQuestion.setAnswerList(userAnswer);
        if(mQuestion.isMultiple_choix()){
            if(count < 3){
                return null;
            }
        }
        return userQuestion;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mOnQuestionnaireListener = (OnQuestionnaireListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context
                    + " must implement Listener");
        }
    }

    public interface OnQuestionnaireListener {
        void onNextPageSelected(Question mQuestion);

        void onPreviousSelected(Question mQuestion);

        void OnSendClick(Question mQuestion);
    }


}