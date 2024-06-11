package com.example.picksix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.picksix.ui.theme.PickSixTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickSixTheme {
                ProfileScreen()
            }
        }
    }

    @Composable
    fun ProfileScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFF9C4)), // Soft pastel yellow
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var preferTeam by remember { mutableStateOf<NFLTeams?>(null) }
            var gettingTeam = ""
            runBlocking { launch { getTeam { newTeam -> gettingTeam = newTeam } } }
            nflTeams.forEach {
                if (gettingTeam.contains(it.name)) {
                    preferTeam = it
                }
            }

            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(
                    id = if (preferTeam != null) {
                        preferTeam?.logo ?: R.drawable.baseline_person_24
                    } else R.drawable.baseline_person_24
                ),
                contentDescription = "logo",
                modifier = Modifier
                    .size(180.dp)
                    .border(4.dp, Color(0xFFFF7043), RoundedCornerShape(15.dp)) // Bright coral
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProfileInfoField(label = "이메일", value = intent.getStringExtra("emailData") ?: "null")
            ProfileInfoField(label = "Point", value = intent.getStringExtra("pointData") ?: "null")
            Text(
                text = "선호팀",
                modifier = Modifier
                    .width(300.dp)
                    .padding(8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333) // Dark grey for readability
            )
            Box {
                var expandedStatus by remember { mutableStateOf(false) }
                TextButton(
                    onClick = { expandedStatus = !expandedStatus },
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFF80CBC4), RoundedCornerShape(15.dp)) // Mint green
                ) {
                    val teamName = preferTeam?.name ?: "선호팀"
                    Text(
                        text = teamName,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                DropdownMenu(
                    expanded = expandedStatus,
                    onDismissRequest = { expandedStatus = false }) {
                    nflTeams.forEach {
                        Text(text = it.name, modifier = Modifier.clickable {
                            preferTeam = it
                            runBlocking { launch { preferTeamUpdate(it.name) } }
                            expandedStatus = false
                        })


                    }
                }
            }
            LottieFootballAnimation()
        }
    }

    @Composable
    fun ProfileInfoField(label: String, value: String) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(vertical = 8.dp) // Reduce vertical padding for closer spacing
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFF3E0)) // Light peach color
                .padding(16.dp)
        ) {
            Text(
                text = label,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333) // Dark grey for readability
            )
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color(0xFF333333), // Dark grey for readability
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
    @Composable
    fun LottieFootballAnimation() {
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.flyingfootball)
        )
        val lottieAnimatable = rememberLottieAnimatable()

        LaunchedEffect(composition) {
            lottieAnimatable.animate(
                composition = composition,
                iterations = LottieConstants.IterateForever,  // 무한 반복
                initialProgress = 0f
            )
        }
        Box() {
            LottieAnimation(
                composition = composition,
                progress = { lottieAnimatable.progress }
            )
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun ProfilePreview() {
        PickSixTheme {
            ProfileScreen()
        }
    }
}
