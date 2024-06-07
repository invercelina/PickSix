package com.example.picksix

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

@Serializable
data class GameData(
    val id: Int? = null,
    val gameDate: String,
    val homeTeam: String,
    val awayTeam: String,
)



fun dateFunction() {
    runBlocking {
        launch {
            withContext(Dispatchers.IO) {
                supabase.from("week1_schedule").insert(gamesWeek1){

                }
            }
        }
    }
}