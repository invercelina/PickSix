package com.example.picksix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picksix.ui.theme.PickSixTheme

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = "PickSix", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Sign up",
                fontSize = 40.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(500.dp)
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var userName by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var nickname by remember { mutableStateOf("") }
                val maxChar = 8
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = userName,
                    onValueChange = { if (it.length <= maxChar) userName = it },
                    label = {
                        Text(text = "username")
                    },
                )
                Text(
                    text = "아이디는 8글자까지 가능합니다",
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(30.dp))
                TextField(
                    value = password, onValueChange = { if (it.length <= maxChar) password = it },
                    label = {
                        Text(text = "password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                Text(
                    text = "비밀번호는 8글자까지 가능합니다",
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
                    text = "닉네임은 8글자까지 가능합니다",
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { /*TODO*/ },
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