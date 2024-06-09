package com.example.picksix

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: String? = null,
    val email: String,
    val nickname: String? = null,
    val point: Int,
    val team: String? = null
)

