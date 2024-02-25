package education.mobile.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textRes: TextView = findViewById(R.id.textResult)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("1")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "1")
            }
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("2")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "2")
            }
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("3")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "3")
            }
        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("4")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "4")
            }
        }
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("5")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "5")
            }
        }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("6")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "6")
            }
        }
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("7")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "7")
            }
        }
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("8")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "8")
            }
        }
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.setText("9")
            }else{
                val text: String = textRes.text.toString()
                textRes.setText(text + "9")
            }
        }
        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener {
            if(!textRes.text.equals(0)){
                val text: String = textRes.text.toString()
                textRes.setText(text + "9")
            }
        }
        val buttonClear: Button = findViewById(R.id.buttonСlear)
        buttonClear.setOnClickListener {
            textRes.setText("0")
        }
        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.setText(text + "+")
        }
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.setText(text + "-")
        }
        val buttonMult: Button = findViewById(R.id.buttonMult)
        buttonMult.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.setText(text + "*")
        }
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.setText(text + "/")
        }
        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            val text: String = textRes.text.toString().substring(0, textRes.text.length-1)
            textRes.setText(text + "/")
        }

    }
}