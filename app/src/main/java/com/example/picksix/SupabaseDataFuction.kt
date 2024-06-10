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

suspend fun getEmail(onEmailReceived: (String) -> Unit) {
    withContext(Dispatchers.IO) {
        // 예시: Supabase에서 이메일 데이터를 가져오는 코드
        val email = supabase.from("profiles").select(columns = Columns.list("email")) {
            filter {
                if (userId != null) {
                    eq("id", userId)
                }
            }
        }
        onEmailReceived(email.data) // 받은 이메일 데이터를 콜백 함수로 전달
    }
}

suspend fun getPoint(onPointReceived: (String) -> Unit) {
    withContext(Dispatchers.IO) {
        // 예시: Supabase에서 포인트 데이터를 가져오는 코드
        val point = supabase.from("profiles").select(columns = Columns.list("point")) {
            filter {
                if (userId != null) {
                    eq("id", userId)
                }
            }
        }
        onPointReceived(point.data) // 받은 포인트 데이터를 콜백 함수로 전달
    }
}
