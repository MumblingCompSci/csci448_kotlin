package com.csci448.garrettquintero_a4.geoquizkotlin

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlin.math.abs

class QuizFragment : Fragment() {
    private val SAVED_INDEX : String = "saved question index"
    private lateinit var mQuestionBank : Array<Question>
    private var mIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mQuestionBank = arrayOf(
                Question(getString(R.string.question_apple), false),
                Question(getString(R.string.question_pineapple), false),
                Question(getString(R.string.question_garble), true)
        )

        /*mQuestionBank = Array<Question>(3, {
            Question(getString(R.string.question_apple), false);
            Question(getString(R.string.question_pineapple), false);
            Question(getString(R.string.question_garble), true);
        })*/

        // TODO : figure out how the fuck to get the index out of the bundle
        /*mIndex = (savedInstanceState?.getInt(SAVED_INDEX))*/

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateText()

        true_button.setOnClickListener { checkAnswer(true) }
        false_button.setOnClickListener { checkAnswer(false) }

        previous_button.setOnClickListener {
            if (mIndex != 0) {
                mIndex--
            }
            /*mIndex = abs(mIndex - 1) % mQuestionBank.size*/
            updateText()
        }

        next_button.setOnClickListener {
            if (mIndex != mQuestionBank.size) {
                mIndex++
            }
            /*mIndex = (mIndex + 1) % mQuestionBank.size*/
            updateText()
        }
    }


    private fun checkAnswer(answer : Boolean) {
        val question = mQuestionBank[mIndex]

        if (question.getAnswer() == answer) {
            getString(R.string.correct_toast)
                    .toast()
        } else {
            getString(R.string.incorrect_toast)
                    .toast()
        }
    }

    private fun updateText() {
        question_text.text = mQuestionBank[mIndex].getQuestion()

        if (mIndex == 0) { previous_button.isEnabled = false }
        else {previous_button.isEnabled = true }

        if (mIndex == (mQuestionBank.size - 1)) { next_button.isEnabled = false }
        else { next_button.isEnabled = true }
    }

    fun String.toast() {
        Toast.makeText(activity, this, Toast.LENGTH_SHORT)
                .show()
    }


}