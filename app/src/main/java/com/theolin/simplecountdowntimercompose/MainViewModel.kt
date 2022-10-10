package com.theolin.simplecountdowntimercompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val countDownFlow = flow<Int> {
        val startingValue = 10
        emit(startingValue)
        var currentValue = startingValue
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }
    init{
        collectFlow()
    }

    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.collect { time->
            println("the current time is $time")

            }
        }
    }
}