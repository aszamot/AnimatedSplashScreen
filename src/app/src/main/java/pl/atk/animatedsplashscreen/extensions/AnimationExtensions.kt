package pl.atk.animatedsplashscreen.extensions

import android.view.animation.Animation
import pl.atk.animatedsplashscreen.utils.__AnimationListener

/**
 * Created by Tomasz on 28.02.2018.
 */
inline fun Animation.setAnimationListener(func: __AnimationListener.() -> Unit) {
    val listener = __AnimationListener()
    listener.func()
    setAnimationListener(listener)
}