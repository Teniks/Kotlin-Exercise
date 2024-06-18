package education.mobile.kotlinex8iw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex8iw.databinding.ActivityGuessingGameBinding
import kotlin.random.Random

class GuessingGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityGuessingGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.guess.setOnClickListener {
            val number = binding.editTextText.text.toString().toIntOrNull()
            if (number != null){
                val i: Int = intent.getIntExtra("max", 0)
                var rand = i

                if (i > 0){
                    rand = Random.nextInt(0, i)
                }

                if(number > i){
                    binding.textView.text = "Не великовато взял?"
                }
                else if(number == rand){
                    binding.textView.text = "А ты догадливый"
                }else{
                    val text = "Попробуй еще раз - было $rand"
                    binding.textView.text = text
                }
            }
        }
    }
}