package com.example.localdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.localdatabase.ui.theme.LocaldatabaseTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocaldatabaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PDataStore()
                }
            }
        }
    }
}

@Composable
fun PDataStore() {

    val context= LocalContext.current
    val appDATA=AppDataStore(context)
    val scope= rememberCoroutineScope()

    scope.launch {
        appDATA.nameSave("SANAN")
        val name= appDATA.nameRead()
        Log.e("name",name)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LocaldatabaseTheme {
        PDataStore()
    }
}