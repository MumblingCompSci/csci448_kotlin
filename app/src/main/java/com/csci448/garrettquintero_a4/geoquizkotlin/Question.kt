package com.csci448.garrettquintero_a4.geoquizkotlin

data class Question(
        private var mQuestion: String,
        private var mAnswer: Boolean) {

    fun getQuestion() : String { return mQuestion }
    fun getAnswer() : Boolean { return mAnswer }
}