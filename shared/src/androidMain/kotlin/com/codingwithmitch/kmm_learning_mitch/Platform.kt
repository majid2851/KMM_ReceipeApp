package com.codingwithmitch.kmm_learning_mitch

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}