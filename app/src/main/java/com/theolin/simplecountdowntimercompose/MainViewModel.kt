package com.theolin.simplecountdowntimercompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countDownFlow
                .filter { time -> time % 2 == 0 } //filtering the result
                .map { time -> time * time }
                .onEach { time -> println(time) }
                .collect { time ->
                    println("the current time is $time")

                }
            //with an accumulator you can use .reduce { accumulator, value ->  }
            //with starter you can use  .fold(initial value) { accumulator, value ->  }

        }
    }


    private fun combineFlows(){
        val flow1 = flow {
            emit(1)
            delay(500L)
            emit(2)
        }

        val
        viewModelScope.launch {
            flow1.flatMapConcat {
                flow
            }
        }

    }
}