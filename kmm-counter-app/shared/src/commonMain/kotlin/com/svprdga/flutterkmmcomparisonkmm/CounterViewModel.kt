package com.svprdga.flutterkmmcomparisonkmm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class CounterModel(val count: Int = 0)

class CounterViewModel {

    // ****************************************** VARS ***************************************** //

    private val _model = MutableStateFlow(CounterModel(0))
    val model: StateFlow<CounterModel> = _model

    // ************************************* PUBLIC METHODS ************************************ //

    fun incrementCount(amount: Int) {
        _model.value = _model.value.copy(count = _model.value.count + amount)
    }
}