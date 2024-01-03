package com.example.digitallemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.digitallemonade.ui.theme.DigitalLemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalLemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeMainView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .padding(10.dp),
            text = stringResource(R.string.lemonade),
            textAlign = TextAlign.Center
        )

        LemonadeWithImageAndText(
            modifier.wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun LemonadeWithImageAndText(modifier: Modifier = Modifier){
    var index by remember{ mutableStateOf(1) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(onClick = { index += 1 }) {
            Image(
                painter = painterResource(id = getImageByIndex(index)),
                contentDescription = "Lemon_Tree"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = getTextByIndex(index))
    }
}

fun getImageByIndex(index:Int):Int{
    return when(index % 4) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
}

fun getTextByIndex(index:Int):String{
    return when(index % 4) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp() {
    DigitalLemonadeTheme {
        LemonadeMainView(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}