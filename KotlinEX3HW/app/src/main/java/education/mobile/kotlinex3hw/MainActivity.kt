package education.mobile.kotlinex3hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:ImageButton = findViewById(R.id.pointerButton)
        val editText:EditText = findViewById(R.id.editTextText)
        val text: TextView = findViewById(R.id.textView)
        val image: ImageView = findViewById(R.id.imageView)


        var name: String = ""
        var mood: String = ""
        button.setOnClickListener {
            if(name.isEmpty()) {
                if(editText.text.isNotEmpty()){
                    name = editText.text.toString()
                    editText.text.clear()
                    editText.setHint(getString(R.string.inputMood))
                }
            }else
            {
                mood = editText.text.toString()
                editText.text.clear()
                if(name.isEmpty()){
                    editText.setHint(getString(R.string.inputName))
                }else{
                    editText.setHint(getString(R.string.inputMood))
                }
            }

            if(mood.isNotEmpty()){
                if(mood.contains("да", true) || mood.contains("yes", true)){
                    val str = name + ", " + getString(R.string.goodMood)
                    text.setText(str)
                    image.setImageResource(R.mipmap.image_oldboy_smile)
                }else{
                    val str = name + ", " + getString(R.string.badMood)
                    text.setText(str)
                    image.setImageResource(R.mipmap.image_oldboy)
                }
            }else{
                text.setText(getString(R.string.hello))
            }
        }
    }
}