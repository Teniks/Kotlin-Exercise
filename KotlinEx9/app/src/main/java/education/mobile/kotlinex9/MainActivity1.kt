package education.mobile.kotlinex9

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex9.databinding.Activity1Binding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: Activity1Binding
    private lateinit var colors: List<Int>
    private var sheetNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = Activity1Binding.inflate(layoutInflater)
        colors = listOf(getColor(R.color.pastel_yellow), getColor(R.color.pastel_blue), getColor(R.color.green_and_beige))
        setContentView(binding.root)
        sheetNumber = intent.getIntExtra("sheetNumber", 0)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sheet)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.fontSizeSeekBar.setMax(50)
        binding.fontSizeSeekBar.setProgress(12)
        binding.fontSizeTextView.setText("Размер шрифта: " + binding.fontSizeSeekBar.progress)

        binding.fontSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.fontSizeTextView.setText("Размер шрифта: " + progress.toString())
                binding.text.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    override fun onPause() {
        super.onPause()
        val prefs = getPreferences(Context.MODE_PRIVATE).edit()

        prefs.putString("note$sheetNumber", binding.text.editableText.toString())
        prefs.apply()
    }

    override fun onResume() {
        super.onResume()

        binding.sheet.setBackgroundColor(colors[sheetNumber])
        val saveState = getPreferences(Context.MODE_PRIVATE).getString("note$sheetNumber", null)

        if (saveState != null){
            binding.text.setText(saveState)
        }
    }

    fun nextSheet(view: View) {
        if(sheetNumber < colors.size){

            val intent = Intent(this, this::class.java)
            intent.putExtra("sheetNumber", sheetNumber + 1)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Это последняя страница", Toast.LENGTH_SHORT).show()
        }
    }
}