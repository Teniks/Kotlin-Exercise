package education.mobile.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBaseValueMain()


        val textPhoto: TextView = findViewById(R.id.textView4)
        val textProject: TextView = findViewById(R.id.textView5)


        textPhoto.setOnClickListener{
            setContentView(R.layout.activity_main)
            setBaseValueMain()
        }
        textProject.setOnClickListener{
            setContentView(R.layout.activity_second)
            setBaseValueMain()
            setBaseValueSecond()
        }
    }

    private fun setBaseValueMain(){
        val textName: TextView = findViewById(R.id.textView3)
        val textAge: TextView = findViewById(R.id.textView2)
        val textSpec: TextView = findViewById(R.id.textView)

        textName.setText(getString(R.string.name) + " " + "Alex")
        textAge.setText(getString(R.string.age) + " " + 18)
        textSpec.setText(getString(R.string.specialise) + " " + "Programmer")
    }

    private fun setBaseValueSecond(){
        val textProjectF: TextView = findViewById(R.id.textProject1)
        val textProjectS: TextView = findViewById(R.id.textProject2)
        val textProjectT: TextView = findViewById(R.id.textProject3)

        textProjectF.setText(getString(R.string.isProject) + " " + "Синий трактор")
        textProjectS.setText(getString(R.string.isProject) + " " + "БМЗ-3311")
        textProjectT.setText(getString(R.string.isProject) + " " + "Эта страничка")

    }
}