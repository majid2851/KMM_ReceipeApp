package com.codingwithmitch.food2forkcompose.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.CircularIndeterminateProgressBar
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.ProcessDialogQueue
import com.codingwithmitch.kmm_learning_mitch.android.presentation.theme.*
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

private val LightThemeColors = lightColors(
  primary = Blue600,
  primaryVariant = Blue400,
  onPrimary = Black2,
  secondary = Color.White,
  secondaryVariant = Teal300,
//  onSecondary = Color.Black,
  error = RedErrorDark,
  onError = RedErrorLight,
  background = Grey1,
  onBackground = Color.Black,
  surface = Color.White,
//  onSurface = Black2,
)
private val DarkColors= darkColors(

)

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun AppTheme(
  displayProgressBar: Boolean,
  dialogQueue:Queue<String> = Queue(mutableListOf()),
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colors = LightThemeColors,
    typography = QuickSandTypography,
    shapes = AppShapes
  ){
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(color = Grey1)
    ){
      ProcessDialogQueue(dialogQueue = dialogQueue)
      content()
      CircularIndeterminateProgressBar(displayProgressBar,0.5f)

    }
  }
}

























