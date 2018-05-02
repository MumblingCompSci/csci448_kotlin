package com.csci448.garrettquintero_a4.geoquizkotlin

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment() {
    private val SAVED_INDEX : String = "saved question index"
    private lateinit var mQuestionBank : Array<Question>
    private var mIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mQuestionBank = Array<Question>(3, {
            Question(getString(R.string.question_apple), false);
            Question(getString(R.string.question_pineapple), false);
            Question(getString(R.string.question_garble), true);
        })

        // TODO : figure out how the fuck to get the index out of the bundle
        /*mIndex = (savedInstanceState?.getInt(SAVED_INDEX))*/

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question_text.text = (mQuestionBank[mIndex].getQuestion())

        true_button.setOnClickListener { checkAnswer(mQuestionBank[mIndex], true) }
        false_button.setOnClickListener { checkAnswer(mQuestionBank[mIndex], false) }

        previous_button.setOnClickListener {
            mIndex--
            updateText()
        }
    
        next_button.setOnClickListener {
            mIndex++
            updateText()
        }
    }


    private fun checkAnswer(question : Question, answer : Boolean) {
        if (question.getAnswer() == answer) {
            getString(R.string.correct_toast)
                    .toast()
        } else {
            getString(R.string.incorrect_toast)
                    .toast()
        }
    }

    fun String.toast() {
        Toast.makeText(activity, this, Toast.LENGTH_SHORT)
                .show()
    }

    private fun updateText() {
        question_text.text = mQuestionBank[mIndex % mQuestionBank.size].getQuestion()
    }
}