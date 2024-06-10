package com.example.picksix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picksix.ui.theme.PickSixTheme
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.filter.PostgrestFilterBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var preferTeam by remember { mutableStateOf<NFLTeams?>(null) }

            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(
                    id = if (preferTeam != null) {
                        (preferTeam as? NFLTeams)?.logo ?: R.drawable.baseline_person_24
                    } else R.drawable.baseline_person_24
                ),
                contentDescription = "logo",
                modifier = Modifier
                    .size(200.dp)
                    .border(2.dp, Color.Blue, RoundedCornerShape(15.dp))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "이메일", modifier = Modifier
                    .width(300.dp)
                    .padding(10.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = intent.getStringExtra("emailData") ?: "null",
                modifier = Modifier.width(300.dp),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .padding(start = 50.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Point", modifier = Modifier
                        .width(200.dp)
                        .padding(start = 8.dp, end = 10.dp),
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            }
            Text(text = intent.getStringExtra("pointData") ?: "null", modifier = Modifier.width(300.dp), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "선호팀", modifier = Modifier
                    .width(300.dp)
                    .padding(10.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Box {
                var expandedStatus by remember { mutableStateOf(false) }
                TextButton(
                    onClick = { expandedStatus = !expandedStatus },
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
                ) {
                    Text(
                        text = "선호팀", color = Color.Black, modifier = Modifier
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
                            expandedStatus = false
                        })
                    }
                }
            }
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
