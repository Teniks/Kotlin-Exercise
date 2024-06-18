package education.mobile.kotlinex8iw

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex8iw.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.guess.setOnClickListener {
            val number = binding.editTextText.text.toString().toIntOrNull()
            if (number != null){
                val txt = "Это " + Random.nextInt(0, number).toString() + "?"
                binding.textView.text = txt
            }
        }

        binding.tryMyself.setOnClickListener{
            val intent = Intent(this, GuessingGameActivity::class.java)
            val number = binding.editTextText.text.toString().toIntOrNull()
            if (number != null){
                intent.putExtra("max", number as Int)
                startActivity(intent)
            }
        }
    }
}