package education.mobile.kotlinex7

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.lime.setOnClickListener {
            binding.root.setBackgroundColor(Color.parseColor("#F6FFF8"))
            binding.colorName.text = binding.lime.text
        }

        binding.palePeach.setOnClickListener {
            binding.root.setBackgroundColor(Color.parseColor("#FED6BC"))
            binding.colorName.text = binding.palePeach.text
        }

        binding.pastelHeavenly.setOnClickListener {
            binding.root.setBackgroundColor(Color.parseColor("#DEF7FE"))
            binding.colorName.text = binding.pastelHeavenly.text
        }
    }
}