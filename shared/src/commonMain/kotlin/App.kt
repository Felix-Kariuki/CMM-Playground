import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}

expect fun getPlatformName(): String

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen() {
    var greetingText by remember { mutableStateOf(getPlatformName()) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painterResource("compose-multiplatform.xml"),
            null
        )

        Text(
            text = "CMM Playground",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Center
        ){
            Button(
                onClick = { greetingText = " ${getPlatformName()}, UI" },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF383688)),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(greetingText, fontSize = 22.sp, color = Color.White,
                    modifier = Modifier.padding(4.dp))
            }
        }
    }
}
