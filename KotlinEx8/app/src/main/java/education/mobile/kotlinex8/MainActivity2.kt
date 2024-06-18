package education.mobile.kotlinex8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex8.databinding.ActivityMain2Binding
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textViewLabel.textSize = 24f
        binding.textViewRandom.textSize = 16f
        binding.root.setBackgroundColor(resources.getColor(R.color.aquamarine))
        showRandomNumber()
    }

    private fun showRandomNumber(){
        val random = Random.nextInt(0, 1000)
        val randomInt = Random.nextInt(0, random)

        binding.textViewRandom.text = randomInt.toString()
        binding.textViewLabel.text = getString(R.string._0_1d, random)
    }
}