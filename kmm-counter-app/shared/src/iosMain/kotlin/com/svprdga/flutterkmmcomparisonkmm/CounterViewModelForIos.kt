package com.svprdga.flutterkmmcomparisonkmm

import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun CounterViewModel.getDefaultState(): CounterModel {
    return CounterModel()
}

fun CounterViewModel.onChange(provideNewModel: ((CounterModel) -> Unit)) : Closeable {

    val job = Job()

    model.onEach {
        provideNewModel(it)
    }.launchIn(
        CoroutineScope(Dispatchers.Main + job)
    )

    return object : Closeable {
        override fun close() {
            job.cancel()
        }
    }
}