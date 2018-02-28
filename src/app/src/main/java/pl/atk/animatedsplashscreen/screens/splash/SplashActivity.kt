package pl.atk.animatedsplashscreen.screens.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import pl.atk.animatedsplashscreen.R
import pl.atk.animatedsplashscreen.extensions.setAnimationListener
import pl.atk.animatedsplashscreen.screens.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animationScaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        val animationScaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        animationScaleDown.setAnimationListener {
            onAnimationEnd { splash_semi_back.startAnimation(animationScaleUp) }
        }

        animationScaleUp.setAnimationListener {
            onAnimationStart { splash_logo.startAnimation(animationFadeOut) }
            onAnimationEnd { startMainActivity() }
        }

        splash_semi_back.startAnimation(animationScaleDown)
    }

    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
