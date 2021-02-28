object Versions {
    const val compose = "1.0.0-alpha10"
    const val navigation = "2.3.2"
    const val retrofit = "2.9.0"
    const val hilt = "2.28-alpha"
    const val hiltLife = "1.0.0-alpha02"
    const val glide = "4.11.0"
    const val okHttp = "4.2.1"
    const val room = "2.2.6"
    const val autoSlider = "1.4.0"
}

object Deps {
    const val ComposeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val ComposeUITooling = "androidx.compose.ui:ui:${Versions.compose}"
    const val ComposeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val ComposeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val ComposeMaterialIcons = "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val ComposeMaterialIconExtends = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val ComposeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val ComposeRXJava2 = "androidx.compose.runtime:runtime-rxjava2:${Versions.compose}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLife}"
    const val hiltXCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltLife}"

    const val glideModule = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val roomRunTime =  "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val slider = "com.github.smarteist:autoimageslider:${Versions.autoSlider}"

    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
}