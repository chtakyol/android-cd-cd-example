package com.cihatakyol.androidcdcdexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cihatakyol.androidcdcdexample.ui.theme.AndroidCdCdExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCdCdExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var showText by remember{ mutableStateOf(false) }
                    Column {
                        Text(
                            text = BuildConfig.BUILD_TYPE,
                            modifier = Modifier.padding(innerPadding)
                        )
                        if (showText) {
                            Text(
                                text = "it's me mario.",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        Button(
                            onClick = {
                                showText = true
                            }
                        ) {
                            Text(
                                text = "Show Mario",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}
