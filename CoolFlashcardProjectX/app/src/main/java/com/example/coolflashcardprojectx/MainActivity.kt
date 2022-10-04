package com.example.coolflashcardprojectx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)

        flashcardQuestion.setOnClickListener {
            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE

            Toast.makeText(this,"Question button was clicked",Toast.LENGTH_SHORT).show()
            Log.i("Osvaldo","Please work")

        }

        flashcardAnswer.setOnClickListener {
            flashcardQuestion.visibility = View.VISIBLE
            flashcardAnswer.visibility = View.INVISIBLE
        }


        //findViewById<View>(R.id.add_question_button).setOnClickListener {
            //val intent = Intent(this, AddCardActivity::class.java)
           //startActivity(intent)
       // }


        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->

            val data: Intent? = result.data

            if (data != null) {
                val questionString = data.getStringExtra("QUESTION_KEY")
                val answerString = data.getStringExtra("ANSWER_KEY")

                flashcardQuestion.text = questionString
                flashcardAnswer.text = answerString

                Log.i("Osvaldo: MainActivity", "question: $questionString")
                Log.i("Osvaldo: MainActivity", "answer: $answerString")
            } else {
                Log.i("Osvaldo: MainActivity", "Returned null data from AddCardActivity")
            }
        }


        val addQuestionButton = findViewById<View>(R.id.add_question_button)
        addQuestionButton.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            // Launch EndingActivity with the resultLauncher so we can execute more code
            // once we come back here from EndingActivity
            resultLauncher.launch(intent)
        }








    }
}
