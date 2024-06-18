package education.mobile.kotlinex6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import education.mobile.kotlinex6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val activityMainBinding: ActivityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(activityMainBinding.root)

        val button = activityMainBinding.button1
        val textView = activityMainBinding.textView1
        button.setOnClickListener {
            textView.text = "Hello, friend!"
        }
        val buttonCount = activityMainBinding.buttonCount
        var counter = 0
        buttonCount.setOnClickListener {
            textView.text = "Я нажал на кнопку " + ++counter + " раз!"
        }
    }
}