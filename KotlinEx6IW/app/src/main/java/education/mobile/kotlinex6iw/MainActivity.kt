package education.mobile.kotlinex6iw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import education.mobile.kotlinex6iw.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var clickCount = 0
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView = binding.counterTextView
        imageView = binding.imageView

        imageView.setImageResource(R.drawable.res_click_n)

        imageView.setOnClickListener {
            clickCount++
            textView.text = "Количество кликов: $clickCount"

            if (clickCount % 2 == 0) {
                imageView.setImageResource(R.drawable.res_click_a)
            }else{
                imageView.setImageResource(R.drawable.res_click_n)
            }

            val randomBackgroundColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            val randomTextColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))

            binding.root.setBackgroundColor(randomBackgroundColor)
            textView.setTextColor(randomTextColor)

            val randomTextSize = 12f + Random.nextInt(20).toFloat()
            textView.textSize = randomTextSize
        }
    }
}