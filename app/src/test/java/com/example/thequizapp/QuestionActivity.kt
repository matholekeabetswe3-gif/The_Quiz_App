package com.example.thequizapp

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity



class QuestionActivity : AppCompatActivity() {



    private lateinit var tvQuestionNumber: TextView

    private lateinit var tvQuestion: TextView

    private lateinit var btnOption1: Button
.
    private lateinit var btnOption2: Button



    private val questionList = listOf(

            "Putting your phone on airplane mode helps it charge faster.", // true

            "Drinking coffee helps you stay hydrated.", // false

            "Writing things down helps you remember them better.", // true

            "Eating late at night always causes weight gain.", // false

            "Using dark mode can save your battery on some phones.", // true

            "You lose most of your body heat through your head." // false

    )





    private val answerList = listOf(true, false, true, false,true,false )



    private var currentIndex = 0

    private var score = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_question)



        tvQuestionNumber = findViewById(R.id.tvQuestionNumber)

        tvQuestion = findViewById(R.id.tvQuestion)

        btnOption1 = findViewById(R.id.btnOption1)

        btnOption2 = findViewById(R.id.btnOption2)



        showQuestion()



        btnOption1.setOnClickListener { checkAnswer(true) }

        btnOption2.setOnClickListener { checkAnswer(false) }

    }



    private fun showQuestion() {
        // Reset button colors back to purple for new question
        btnOption1.backgroundTintList = getColorStateList(R.color.purple_500)
        btnOption2.backgroundTintList = getColorStateList(R.color.purple_500)

        tvQuestion.text = questionList[currentIndex]
        tvQuestionNumber.text = "Question ${currentIndex + 1} of ${questionList.size}"

        btnOption1.text = "TRUE / HACK"
        btnOption2.text = "FALSE / MYTH"

        btnOption1.isEnabled = true
        btnOption2.isEnabled = true
    }


    private fun checkAnswer(selectedAnswer: Boolean) {
        btnOption1.isEnabled = false
        btnOption2.isEnabled = false

        if (selectedAnswer == answerList[currentIndex]) {
            score++
            // Correct answer - turn the button they clicked GREEN
            if (selectedAnswer) {
                btnOption1.backgroundTintList = getColorStateList(R.color.green)
            } else {
                btnOption2.backgroundTintList = getColorStateList(R.color.green)
            }
            Toast.makeText(this, "Correct! It's a ${if(selectedAnswer) "Hack" else "Myth"}!", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer - turn the button they clicked RED
            if (selectedAnswer) {
                btnOption1.backgroundTintList = getColorStateList(R.color.red)
            } else {
                btnOption2.backgroundTintList = getColorStateList(R.color.red)
            }
            val correct = if(answerList[currentIndex]) "Hack" else "Myth"
            Toast.makeText(this, "Wrong! It's actually a $correct", Toast.LENGTH_SHORT).show()
        }

        currentIndex++

        if (currentIndex < questionList.size) {
            tvQuestion.postDelayed({ showQuestion() }, 1500)
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL", questionList.size)
            startActivity(intent)
            finish()
        }
    }



         if (selectedAnswer == answerList[currentIndex]) {

            score++

            Toast.makeText(this, "Correct! It's a ${if(selectedAnswer) "Hack" else "Myth"}!", Toast.LENGTH_SHORT).show()

        } else {

            val correct = if(answerList[currentIndex]) "Hack" else "Myth"

            Toast.makeText(this, "Wrong! It's actually a $correct", Toast.LENGTH_SHORT).show()

        }



        currentIndex++



        if (currentIndex < questionList.size) {

            tvQuestion.postDelayed({ showQuestion() }, 1500)

        } else {

            val intent = Intent(this, ScoreActivity::class.java)

            intent.putExtra("SCORE", score)

            intent.putExtra("TOTAL", questionList.size)

            startActivity(intent)

            finish()

        }

    }

}
