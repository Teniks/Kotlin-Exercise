package education.mobile.kotlinex12

import android.os.Build
import android.os.Bundle
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val popupMenu = PopupMenu(this, binding.imageView)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item1 -> {
                    binding.text.text = "Нажат пункт PopupMenu 1"
                    true
                }

                R.id.item2 -> {
                    binding.text.text = "Нажат пункт PopupMenu 2"
                    true
                }

                R.id.item3 -> {
                    binding.text.text = "Нажат пункт PopupMenu 3"
                    true
                }

                else -> false
            }
        }

        binding.imageView.setOnClickListener {
            popupMenu.show()
        }

        val popupMenu2 = PopupMenu(this, binding.imageView)
        popupMenu2.inflate(R.menu.popupmenu_2)
        popupMenu2.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item1 -> {
                    binding.text.text = "Вы выбрали пастельный оранжевый"
                    true
                }

                R.id.item2 -> {
                    binding.text.text = "Вы выбрали желтый Крайола"
                    true
                }

                R.id.item3 -> {
                    binding.text.text = "Вы выбрали салатовый"
                    true
                }
            }
            false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenu2.setForceShowIcon(true)
        }

        binding.button.setOnClickListener {
            popupMenu2.show()
        }


        val popupMenu3 = PopupMenu(this, binding.imageView)
        popupMenu3.inflate(R.menu.popupmenu_3)
        popupMenu3.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item1 -> {
                    binding.text.text = "Нажат пункт PopupMenu 1"
                    binding.text.textSize = 16F
                    true
                }

                R.id.item2 -> {
                    binding.text.text = "Нажат пункт PopupMenu 2"
                    binding.text.textSize = 24F
                    true
                }

                R.id.item3 -> {
                    binding.text.text = "Нажат пункт PopupMenu 3"
                    binding.text.textSize = 32F
                    true
                }

                else -> false
            }
        }

        binding.text.setOnClickListener {
            popupMenu3.show()
        }

    }
}