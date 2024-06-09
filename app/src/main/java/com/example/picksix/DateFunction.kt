package com.example.picksix

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable


@Serializable
data class GameData(
    val id: Int? = null,
    val game_date: String,
    val home_team: String,
    val away_team: String,
    val win: Int? = null,
)

val gameData = gamesWeek18.map { game ->
    GameData(
        game_date = game.gameDate,
        home_team = game.homeTeam.name,
        away_team = game.awayTeam.name,
    )
}



fun dateFunction() {
    runBlocking {
        launch {
            withContext(Dispatchers.IO) {
                supabase.from("week18_schedule").insert(gameData) {

                }
            }
        }
    }
}