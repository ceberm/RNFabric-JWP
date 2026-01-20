package com.demo.compose.ui.jw

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.viewmodel.VideoViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Video(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    modifier: Modifier = Modifier
) {
  val viewModel: VideoViewModel = viewModel()

  VideoPlayer(
    modifier = modifier,
    videoState = viewModel.uiState.collectAsState().value,
    lifecycleOwner = lifecycleOwner,
    handleEvent = viewModel::handleEvent
  )
}