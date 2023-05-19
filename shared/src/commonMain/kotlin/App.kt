import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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


@Composable
fun HomeScreen() {


    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            PhonesUi()
        }else{
            DesktopUi()
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DesktopUi() {
    var platformName by remember { mutableStateOf(getPlatformName()) }

    Row(Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource("compose-multiplatform.xml"),
            null,
            modifier = Modifier
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CMM Playground",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Column(
                modifier = Modifier.fillMaxHeight(.5f),
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { platformName = " ${getPlatformName()}, UI" },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF383688)),
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        platformName, fontSize = 22.sp, color = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PhonesUi() {
    var platformName by remember { mutableStateOf(getPlatformName()) }
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
        ) {
            Button(
                onClick = { platformName = " ${getPlatformName()}, UI" },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF383688)),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    platformName, fontSize = 22.sp, color = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
