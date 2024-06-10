package com.example.picksix

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

val auth = supabase.auth
val currentUser = auth.currentUserOrNull()
val userId = currentUser?.id


var week1Prediction: MutableList<Boolean?> = MutableList(gamesWeek1.size) { null }

@Serializable
data class Week1Prediction(
    val id: String? = null,
    val game1_prediction: Boolean? = null,
    val game2_prediction: Boolean? = null,
    val game3_prediction: Boolean? = null,
    val game4_prediction: Boolean? = null,
    val game5_prediction: Boolean? = null,
    val game6_prediction: Boolean? = null,
    val game7_prediction: Boolean? = null,
    val game8_prediction: Boolean? = null,
    val game9_prediction: Boolean? = null,
    val game10_prediction: Boolean? = null,
    val game11_prediction: Boolean? = null,
    val game12_prediction: Boolean? = null,
    val game13_prediction: Boolean? = null,
    val game14_prediction: Boolean? = null,
    val game15_prediction: Boolean? = null,
    val game16_prediction: Boolean? = null,
)


fun predictionFunction() {
    runCatching {
        runBlocking {
            launch {
                val week1PredictSubmit = Week1Prediction(
                    id = userId,
                    game1_prediction = week1Prediction.getOrNull(0),
                    game2_prediction = week1Prediction.getOrNull(1),
                    game3_prediction = week1Prediction.getOrNull(2),
                    game4_prediction = week1Prediction.getOrNull(3),
                    game5_prediction = week1Prediction.getOrNull(4),
                    game6_prediction = week1Prediction.getOrNull(5),
                    game7_prediction = week1Prediction.getOrNull(6),
                    game8_prediction = week1Prediction.getOrNull(7),
                    game9_prediction = week1Prediction.getOrNull(8),
                    game10_prediction = week1Prediction.getOrNull(9),
                    game11_prediction = week1Prediction.getOrNull(10),
                    game12_prediction = week1Prediction.getOrNull(11),
                    game13_prediction = week1Prediction.getOrNull(12),
                    game14_prediction = week1Prediction.getOrNull(13),
                    game15_prediction = week1Prediction.getOrNull(14),
                    game16_prediction = week1Prediction.getOrNull(15)
                )
                withContext(Dispatchers.IO) {
                    Log.d("week1Prediction", week1Prediction.toString())
                    Log.d("week1PredictGetOrNull", week1Prediction.getOrNull(0).toString())
                    Log.d("week1PredictSubmit", week1PredictSubmit.toString())
                    supabase.from("week01_predictions").insert(week1PredictSubmit)
                }
            }
        }
    }
}


