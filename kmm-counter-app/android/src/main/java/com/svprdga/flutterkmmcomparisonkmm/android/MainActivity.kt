package com.svprdga.flutterkmmcomparisonkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.svprdga.flutterkmmcomparisonkmm.CounterModel
import com.svprdga.flutterkmmcomparisonkmm.CounterViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

@Composable
private fun CounterView(model: CounterModel, viewModel: CounterViewModel) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Counter value: ${model.count}")
        Button(onClick = {
            viewModel.incrementCount(1)
        }) {
            Text("Increment")
        }
    }
}

class MainActivity : ComponentActivity() {

    // ****************************************** VARS ***************************************** //

    private val viewModel = CounterViewModel()

    // *************************************** LIFECYCLE *************************************** //

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {

            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.model.collect { model ->
                    setContent {
                        CounterView(model, viewModel)
                    }
                }
            }
        }
    }
}
