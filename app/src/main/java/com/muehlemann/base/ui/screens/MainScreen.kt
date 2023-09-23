package com.muehlemann.base.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.muehlemann.base.ui.viewmodels.MainViewModel

@Composable
fun MainScreen(
  viewModel: MainViewModel = hiltViewModel()
) {
  // Network
  val networkError by remember { viewModel.networkError }
  if (networkError) {
    // Some UI
  }

  val response by viewModel.get().collectAsState(initial = null)
  response?.let { model ->
    // Some UI
  }

}


