package com.example.hw7exercise1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import java.util.Collections.emptyList


private const val TAG = "CrimeListViewModel"
private val crimeRepository = CrimeRepository.get()

class CrimeListViewModel : ViewModel() {

    private val _crimes: MutableStateFlow<List<Crime>> = MutableStateFlow(emptyList())
    val crimes: StateFlow<List<Crime>>
        get() = _crimes.asStateFlow()


    init {
        // Log.d(TAG, "init starting")
        viewModelScope.launch {

            crimeRepository.getCrimes().collect {
                _crimes.value = it
            }

        }

    }

}