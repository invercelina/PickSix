package com.example.picksix

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picksix.ui.theme.PickSixTheme
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PicksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickSixTheme {
                PicksScreen()
            }
        }
    }

    @Composable
    fun PicksScreen() {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            item {
                var isPickScreen by remember { mutableStateOf(true) }
                var clickWeek by remember { mutableStateOf(1) }
                var emailData by remember { mutableStateOf("") }
                var pointData by remember { mutableStateOf("") }
                var leaderList by remember { mutableStateOf<List<Leader>>(listOf()) }
                val context = LocalContext.current as? Activity

                Column(
                    modifier = Modifier
                        .height(130.dp)
                        .fillMaxWidth()
                        .background(Color.Blue),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        // 이 버튼은 ProfileActivity로 가는 버튼입니다

                        Button(
                            onClick = {
                                val intent = Intent(context, ProfileActivity::class.java)
                                runBlocking {
                                    launch {
                                        getEmail { newMail ->
                                            emailData = newMail
                                        }
                                        var emailEx = ""
                                        for (i in 11..emailData.length - 4) {
                                            emailEx += emailData[i]
                                        }
                                        intent.putExtra("emailData", emailEx)
                                        getPoint { newPoint ->
                                            pointData = newPoint
                                        }
                                        var pointEx = ""
                                        for (i in 10..pointData.length - 3) {
                                            pointEx += pointData[i]
                                        }
                                        intent.putExtra("pointData", pointEx)
                                    }
                                }
                                context?.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            modifier = Modifier
                                .size(60.dp)
                                .border(1.dp, Color.Red, CircleShape)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.Black)
                ) {
                    // 이 버튼은 PicksActivity로 가는 버튼입니다
                    TextButton(
                        onClick = { isPickScreen = true },
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Text(text = "Make Picks", color = Color.White)
                    }
                    // 이 버튼은 LeaderboardActivity로 가는 버튼입니다
                    TextButton(
                        onClick = { isPickScreen = false },
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Text(text = "Leaderboard", color = Color.White)
                    }
                }
                if (isPickScreen) {
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Makes Your Picks Now", fontWeight = FontWeight.Black)
                        Text("Make at least one pick to get started!\nWinning Picks are worth 10 points.")
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        item {
                            weekList.forEach { week ->
                                WeekMain(week = week,
                                    isSelected = (clickWeek == week.week),
                                    onClick = {
                                        clickWeek = it
                                    })
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    gamesWeekList[clickWeek - 1].forEachIndexed { index, gamesOfWeek ->
                        GameCard(
                            game = gamesOfWeek,
                            onClick = { clicked -> week1Prediction[index] = clicked })
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 이 버튼은 픽 제출할 때 쓰는 버튼입니다

                        Button(onClick = {
                            runCatching {
                                runBlocking {
                                    launch {
                                        predictionFunction()
                                    }
                                }
                            }.onSuccess {
                                val toast =
                                    Toast.makeText(context, "제출이 완료되었습니다", Toast.LENGTH_SHORT)
                                toast.show()
                            }.onFailure {
                                val toast =
                                    Toast.makeText(context, "제출 실패하였습니다", Toast.LENGTH_SHORT)
                                toast.show()
                            }
                        }) {
                            Text(text = "Submit")
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Leaderboard", fontWeight = FontWeight.Black, fontSize = 50.sp)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(550.dp)
                            .background(Color.White)
                    ) {
                        runBlocking { launch { leaderList = getLeaders() } }
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            leaderList.forEach {
                                Text(text = "${it.nickname}")
                            }
                        }
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            leaderList.forEach {
                                Text(text = "${it.point}")
                            }
                        }
                    }
                }
            }
        }
    }

    // 주 고르는 버튼
    @Composable
    fun WeekMain(week: Week, isSelected: Boolean, onClick: (Int) -> Unit) {
        Button(
            onClick = { onClick(week.week) },
            colors = ButtonDefaults.buttonColors(containerColor = if (isSelected) Color(0xFF6DF6EA) else Color.White),
            modifier = Modifier
                .width(160.dp)
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                .border(
                    2.dp,
                    if (isSelected) Color.Blue else Color.LightGray,
                    RoundedCornerShape(5.dp)
                ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Week ${week.week}", color = Color.Black)
                Text(text = week.period, color = Color.Gray)
            }
        }
    }

    // 게임 카드
    @Composable // save
    fun GameCard(
        game: Game,
        onClick: (Boolean?) -> Unit
    ) {
        Column {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.elevatedCardElevation(8.dp)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = game.gameDate,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Divider(modifier = Modifier.padding(top = 6.dp, bottom = 10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(horizontal = 15.dp)
                    ) {

                        Box(modifier = Modifier.weight(1f)) {
                            Surface(
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier.padding(horizontal = 10.dp),
                                shadowElevation = 8.dp,
                                color = Color.White,
                                border = if (game.isHomeTeamClicked.value == true) {
                                    BorderStroke(2.dp, Color.Blue)
                                } else null
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.clickable {
                                        game.isHomeTeamClicked.value = true
                                        onClick(game.isHomeTeamClicked.value)
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth()
                                            .background(game.homeTeam.color),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = game.homeTeam.logo),
                                            contentDescription = "logo",
                                            modifier = Modifier.size(30.dp)
                                        )
                                    }
                                    Column(
                                        modifier = Modifier.weight(1f),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = game.homeTeam.name,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                        Text(text = "65% Picked", fontSize = 10.sp)
                                    }
                                }
                            }
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            Surface(
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier.padding(horizontal = 10.dp),
                                shadowElevation = 8.dp,
                                color = Color.White,
                                border = if (game.isHomeTeamClicked.value == false) {
                                    BorderStroke(2.dp, Color.Blue)
                                } else null
                            ) {

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.clickable {
                                        game.isHomeTeamClicked.value = false
                                        onClick(game.isHomeTeamClicked.value)
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth()
                                            .background(game.awayTeam.color),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = game.awayTeam.logo),
                                            contentDescription = "logo",
                                            modifier = Modifier.size(30.dp)
                                        )
                                    }
                                    Column(
                                        modifier = Modifier.weight(1f),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = game.awayTeam.name,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                        Text(text = "35% Picked", fontSize = 10.sp)
                                    }
                                }
                            }

                        }

                    }
                    Divider(modifier = Modifier.padding(top = 15.dp))
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Detail",
                            modifier = Modifier.padding(top = 3.dp, start = 10.dp),
                            fontSize = 12.sp,
                            color = Color.Blue
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun PicksPreview() {
        PickSixTheme {
            PicksScreen()
        }
    }
}