package com.example.picksix

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picksix.ui.theme.PickSixTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

suspend fun signUpNewUser(userMail: String, userPassword: String, nickname: String) {
    supabase.auth.signUpWith(Email) {
        email = userMail
        password = userPassword
        data = buildJsonObject {
            put("nickname", nickname)
        }
    }
}


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickSixTheme {
                SignUpScreen()
            }
        }
    }

    @Composable
    fun SignUpScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            val context = LocalContext.current as? Activity
            Image(
                painter = painterResource(id = R.drawable.picksixlogo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            Text(
                text = "Sign up",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(410.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var nickname by remember { mutableStateOf("") }
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
                Text(
                    text = "6자부터 ${maxChar}글자까지 가능합니다",
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = nickname, onValueChange = { if (it.length <= maxChar) nickname = it },
                    label = {
                        Text(text = "nickname")
                    },
                )
                Text(
                    text = "${maxChar}글자까지 가능합니다",
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        runCatching {
                            runBlocking {
                                launch {
                                    // 여기에 코루틴이 실행될 코드를 작성
                                    signUpNewUser(email, password, nickname)
                                }
                            }
                        }.onSuccess {
                            // 회원가입 성공 시 수행할 작업
                            val toast = Toast.makeText(context, "회원가입 완료", Toast.LENGTH_SHORT)
                            toast.show()
                            context?.finish()
                        }.onFailure { e ->
                            // 회원가입 실패 시 수행할 작업
                            // 예외 처리
                            Log.e("SignUpError", "회원가입 중 오류 발생: ${e.message}", e)
                            // 적절한 오류 처리 작업 수행
                            val message = when {
                                e.message?.contains("Unable to validate email address: invalid format") == true -> "올바른 이메일 형식을 입력해주세요"
                                e.message?.contains("Password should be at least 6 characters.") == true -> "비밀번호는 최소 6자리 이상 입력해주세요"
                                e.message?.contains("Anonymous sign-ins are disabled") == true -> "이메일을 입력해주세요"
                                e.message?.contains("User already registered") == true -> "이미 회원가입된 이메일입니다"
                                else -> null
                            }
                            val toast = Toast.makeText(
                                context,
                                "회원가입 중 오류 발생: $message",
                                Toast.LENGTH_SHORT
                            )
                            toast.show() // 토스트 메시지를 보여주는 show() 메소드 호출
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFA8EE5))
                ) {
                    Text(text = "Sign up")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SignUpPreview() {
        PickSixTheme {
            SignUpScreen()
        }
    }
}
