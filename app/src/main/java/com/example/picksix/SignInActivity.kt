package com.example.picksix

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picksix.ui.theme.PickSixTheme
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun signInWithEmail(userMail: String, userPassword: String) {
    supabase.auth.signInWith(Email) {
        email = userMail
        password = userPassword
    }
}

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickSixTheme {
                SignInScreen()
            }
        }
    }

    @Composable
    fun SignInScreen() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "PickSix",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Sign in",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                val context = LocalContext.current as? Activity
                val maxChar = 20
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(text = "email")
                    },
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = password, onValueChange = { if (it.length <= maxChar) password = it },
                    label = {
                        Text(text = "password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {
                        runCatching {
                            runBlocking {
                                launch {
                                    signInWithEmail(email, password)
                                }
                            }
                        }.onSuccess {
                            // 로그인 성공 시 수행할 작업
                            updateUserId()
                            val intent = Intent(context, PicksActivity::class.java)
                            context?.startActivity(intent)
                        }.onFailure { e ->
                            // 로그인 실패 시 수행할 작업
                            // 예외 처리
                            Log.e("SignInError", "로그인 중 오류 발생: ${e.message}", e)
                            // 적절한 오류 처리 작업 수행
                            val message =
                                if (e.message?.contains("invalid_grant (Invalid login credentials)") == true) {
                                    "이메일이나 비밀번호를 확인해주세요"
                                } else null
                            val toast = Toast.makeText(
                                context,
                                "로그인 중 오류 발생: $message",
                                Toast.LENGTH_SHORT
                            )
                            toast.show() // 토스트 메시지를 보여주는 show() 메소드 호출
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFD3BC8D))
                ) {
                    Text(
                        text = "Sign in",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SignInPreview() {
        PickSixTheme {
            SignInScreen()
        }
    }

}