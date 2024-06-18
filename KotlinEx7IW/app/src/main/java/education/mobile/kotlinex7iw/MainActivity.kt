package education.mobile.kotlinex7iw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex7iw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.fourteen.setOnClickListener{
            binding.textView.text = "Это текст с размером 14"
            binding.textView.textSize = 14f
        }

        binding.twentyFour.setOnClickListener{
            binding.textView.text = "Это текст с размером 24"
            binding.textView.textSize = 24f
        }
        binding.thirtyTwo.setOnClickListener{
            binding.textView.text = "Это текст с размером 32"
            binding.textView.textSize = 32f
        }
    }
}