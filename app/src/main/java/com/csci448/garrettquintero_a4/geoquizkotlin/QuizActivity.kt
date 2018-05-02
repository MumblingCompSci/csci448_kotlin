package com.csci448.garrettquintero_a4.geoquizkotlin

import android.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var fragment: Fragment? = fragmentManager
                .findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = QuizFragment()
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }

    }
}
