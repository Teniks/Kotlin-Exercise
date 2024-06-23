package education.mobile.kotlinex11iw

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import education.mobile.kotlinex11iw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        val sunsetAnimation = AnimationUtils.loadAnimation(this, R.anim.sunset)
        val clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        val hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn)
        val hourTurn12Animation = AnimationUtils.loadAnimation(this, R.anim.hour_turn_12)

        sunRiseAnimation.setAnimationListener ( object : Animation.AnimationListener {
         override fun onAnimationStart(animation: Animation) {}
         override fun onAnimationRepeat(animation: Animation?) {}
         override fun onAnimationEnd(animation: Animation?) {
             binding.sun.startAnimation(sunsetAnimation)
             binding.clock.startAnimation(clockTurnAnimation)
             binding.hourHand.startAnimation(hourTurn12Animation)
            }
        })

        binding.sun.startAnimation(sunRiseAnimation)
        binding.clock.startAnimation(clockTurnAnimation)
        binding.hourHand.startAnimation(hourTurnAnimation)
    }
}