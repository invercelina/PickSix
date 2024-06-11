package com.example.picksix

import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

@Serializable
data class Leader(
    val nickname: String? = null,
    val point: Int,
)


suspend fun getEmail(onEmailReceived: (String) -> Unit) {
    withContext(Dispatchers.IO) {
        // 예시: Supabase에서 이메일 데이터를 가져오는 코드
        val email = supabase.from("profiles").select(columns = Columns.list("email")) {
            filter {
                val currentUserId = userId
                if (currentUserId != null) {
                    eq("id", currentUserId)
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
                val currentUserId = userId
                if (currentUserId != null) {
                    eq("id", currentUserId)
                }
            }
        }
        onPointReceived(point.data) // 받은 포인트 데이터를 콜백 함수로 전달
    }
}

suspend fun preferTeamUpdate(team: String) {
    withContext(Dispatchers.IO) {
        supabase.from("profiles").update(
            {
                set("team", team)
            }
        ) {
            filter {
                val currentUserId = userId
                if (currentUserId != null) {
                    eq("id", currentUserId)
                }
            }
        }
    }
}

suspend fun getTeam(onTeamReceived: (String) -> Unit) {
    withContext(Dispatchers.IO) {
        // 예시: Supabase에서 포인트 데이터를 가져오는 코드
        val team = supabase.from("profiles").select(columns = Columns.list("team")) {
            filter {
                val currentUserId = userId
                if (currentUserId != null) {
                    eq("id", currentUserId)
                }
            }
        }
        onTeamReceived(team.data) // 받은 포인트 데이터를 콜백 함수로 전달
    }
}

suspend fun getLeaders(): List<Leader> {
    val result = supabase.from("profiles").select(columns = Columns.list("nickname", "point"))
        .decodeAs<List<Leader>>()
    return result.sortedByDescending { it.point }
}


