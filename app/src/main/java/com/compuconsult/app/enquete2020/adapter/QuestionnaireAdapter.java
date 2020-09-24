package com.compuconsult.app.enquete2020.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.compuconsult.app.enquete2020.fragment.QuestionnaireFragment;
import com.compuconsult.app.enquete2020.model.Question;

import java.util.List;

public class QuestionnaireAdapter extends FragmentStatePagerAdapter {

    private  List<Question> questions;
    public QuestionnaireAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.questions = questions;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return QuestionnaireFragment.newInstance(questions.get(position), position);
    }

    @Override
    public int getCount() {
        return questions.size();
    }
}
