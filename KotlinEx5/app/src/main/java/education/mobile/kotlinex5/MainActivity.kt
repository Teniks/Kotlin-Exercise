package education.mobile.kotlinex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import education.mobile.kotlinex5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var currentQuestionIndex = 0
    val questions = listOf(
        Question("Какая планета является самой большой в Солнечной системе?",
            listOf("Земля", "Марс", "Юпитер", "Сатурн"), 2),
        Question("Кто написал роман «Война и мир»?",
            listOf("Лев Толстой", "Фёдор Достоевский", "Александр Пушкин", "Николай Гоголь"), 0),
        Question("Какой город является столицей Франции?",
            listOf("Берлин", "Лондон", "Париж", "Рим"), 2),
        Question("Какое животное является символом Австралии?",
            listOf("Кенгуру", "Лев", "Слон", "Носорог"), 0),
        Question("Какой цвет у светофора означает «стоп»?",
            listOf("Зеленый", "Красный", "Желтый", "Синий"), 1),
        Question("Какая самая высокая гора в мире?",
            listOf("Килиманджаро", "Эверест", "Канченджанга", "Лхоцзе"), 1),
        Question("Сколько дней в году?",
            listOf("364", "365", "366", "367"), 1),
        Question("Какой химический элемент имеет символ «Au»?",
            listOf("Серебро", "Золото", "Платина", "Медь"), 1)
    )

    var score: Int = 0
    lateinit var activityMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMain.root)

        activityMain.button1.setOnClickListener { checkAnswer(0) }
        activityMain.button2.setOnClickListener { checkAnswer(1) }
        activityMain.button3.setOnClickListener { checkAnswer(2) }
        activityMain.button4.setOnClickListener { checkAnswer(3) }

        loadQuestion()
    }

    private fun loadQuestion(){
        if (currentQuestionIndex < questions.size){
            val buttons = listOf(activityMain.button1, activityMain.button2, activityMain.button3, activityMain.button4)

            val currentQuestion = questions[currentQuestionIndex]

            activityMain.question.text = currentQuestion.text

            for (i in currentQuestion.options.indices){
                buttons[i].text = currentQuestion.options[i]
            }
        }
    }

    private fun checkAnswer(selectedAnswerIndex: Int){
        val question = questions[currentQuestionIndex]
        if(selectedAnswerIndex == question.correctAnswerIndex){
            score += 1000
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size){
                loadQuestion()
            }else{
                showResult()
            }
        }else{
            showResult()
        }
    }

    private fun showResult(){
        activityMain.question.text = "Вот и результат!\n" + score
        currentQuestionIndex = 0
    }
}

data class Question(val text: String, val options: List<String>, val correctAnswerIndex: Int)