package com.theolin.simplecountdowntimercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.theolin.simplecountdowntimercompose.ui.theme.SimpleCountDownTimerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCountDownTimerComposeTheme {
                val viewModel = viewModels<MainViewModel>()
                val number = viewModel.value.countDownFlow.collectAsState(initial = 10)
                Box(modifier = Modifier.fillMaxSize()){
                    Text(
                        text = number.value.toString(),
                        fontSize = 30.sp ,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}
