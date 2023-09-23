package com.muehlemann.base.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.muehlemann.base.models.Model
import com.muehlemann.base.network.services.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val apiService: ApiService,
) : ViewModel() {

  val networkError: MutableState<Boolean> = mutableStateOf(false)

  fun get(): Flow<Model?> {
    return apiService.get()
      .onEach {
        networkError.value = false
      }
      .catch {
        networkError.value = true
        emit(null)
      }
      .flowOn(Dispatchers.IO)
  }

}