package education.mobile.kotlinex4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textRes: TextView = findViewById(R.id.textResult)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "1"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "1"
            }
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "2"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "2"
            }
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "3"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "3"
            }
        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "4"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "4"
            }
        }
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "5"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "5"
            }
        }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "6"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "6"
            }
        }
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "7"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "7"
            }
        }
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "8"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "8"
            }
        }
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener {
            if(textRes.text.equals(0)){
                textRes.text = "9"
            }else{
                val text: String = textRes.text.toString()
                textRes.text = text + "9"
            }
        }
        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener {
            if(!textRes.text.equals(0)){
                val text: String = textRes.text.toString()
                textRes.text = text + "9"
            }
        }
        val buttonClear: Button = findViewById(R.id.buttonСlear)
        buttonClear.setOnClickListener {
            textRes.text = "0"
        }
        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.text = "$text+"
        }
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.text = "$text-"
        }
        val buttonMult: Button = findViewById(R.id.buttonMult)
        buttonMult.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.text = "$text*"
        }
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener {
            val text: String = textRes.text.toString()
            textRes.text = "$text/"
        }
        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            val text: String = if(textRes.text.isNotBlank()) textRes.text.toString().substring(0, textRes.text.length-1) else ""
            textRes.text = text
        }

        val textHistory: TextView = findViewById(R.id.textHistory)
        val buttonResult: Button = findViewById(R.id.buttonResult)
        buttonResult.setOnClickListener {
            val text: String = textRes.text.toString()

            textHistory.text = if(textHistory.text.isNotBlank()) textHistory.text.toString() + "\n" + text else text
            var massTxt = textHistory.text.split("\n")

            if(massTxt.size > 6){
                massTxt = massTxt.subList(1, massTxt.size-1)
                textHistory.text = null
                for(str in massTxt){
                    val txt: String
                    if(textHistory.text.isNotBlank()){
                        txt = textHistory.text.toString()

                        textHistory.text = txt + str
                    }else{
                        textHistory.text = str
                    }

                    if(massTxt.indexOf(str) != massTxt.size-1){
                        textHistory.text = textHistory.text.toString() + "\n"
                    }
                }
            }
            try {
                val expr = ExpressionBuilder(text).build()
                val result = expr.evaluate().toLong()
                textRes.text = result.toString()
            }catch (e: Exception) {
                textRes.text = "ERROR"
            }
        }
    }
}