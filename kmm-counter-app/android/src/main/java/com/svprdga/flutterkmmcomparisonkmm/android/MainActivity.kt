package com.svprdga.flutterkmmcomparisonkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    Scaffold(
        topBar = { TopAppBar(title = { Text("KMM version - Android") }) }
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column {
                Text("You have pushed the button this many times:")
                Text("${model.count}")
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onClick = { viewModel.incrementCount(1) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = null
                )
            }
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
