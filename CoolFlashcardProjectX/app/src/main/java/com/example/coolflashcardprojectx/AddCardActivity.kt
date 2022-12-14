package com.example.coolflashcardprojectx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val questionEditText = findViewById<EditText>(R.id.flashcard_question_edittext)
        val answerEditText = findViewById<EditText>(R.id.flashcard_answer_edittext)

        //findViewById<View>(R.id.cancel_question_button).setOnClickListener {
            //finish()
        //}

        //findViewById<View>(R.id.save_question_button).setOnClickListener {

            //finish()
        //}

        val saveButton = findViewById<ImageView>(R.id.save_question_button)
        saveButton.setOnClickListener {
            val questionString = questionEditText.text.toString()
            val answerString = answerEditText.text.toString()

            val data = Intent()
            data.putExtra("QUESTION_KEY", questionString)
            data.putExtra("ANSWER_KEY", answerString)

            setResult(RESULT_OK, data)
            finish()
        }

        val cancelButton = findViewById<ImageView>(R.id.cancel_question_button)
        cancelButton.setOnClickListener {
            finish()
        }



    }
}