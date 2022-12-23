package com.example.studyapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.studyapp.R;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class IntroSlider extends AppIntro {

    // we are calling on create method
    // to generate the view for our java file.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is for adding the new slide to our app.
        // we are creating a new instance and inside that
        // we are adding the title, description, image and
        // background color for our slide.
        // below line is use for creating first slide
        addSlide(AppIntroFragment.newInstance("Welcome", "A Productivity App",
                R.drawable.logo_final, ContextCompat.getColor(getApplicationContext(), R.color.purple_500)));

        // below line is for creating second slide.
        addSlide(AppIntroFragment.newInstance("To Do List", "Keep track of your tasks using the to do list", R.drawable.to_do_list,
                ContextCompat.getColor(getApplicationContext(), R.color.purple_500)));

        // below line is use to create third slide.
        addSlide(AppIntroFragment.newInstance("Timer", "Keep track of the time spent on each activity", R.drawable.timer_slide,
                ContextCompat.getColor(getApplicationContext(), R.color.purple_500)));

        setScrollDurationFactor(2);


    }


    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    public static final String COMPLETED_ONBOARDING_PREF_NAME = "Onboarding Completed";

    public void finishTutorial(){
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        sharedPreferencesEditor.putBoolean(
                COMPLETED_ONBOARDING_PREF_NAME, true);
        sharedPreferencesEditor.apply();

        finish();
    }
}
