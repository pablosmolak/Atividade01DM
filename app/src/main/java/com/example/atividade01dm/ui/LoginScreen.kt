package com.example.atividade01dm.ui

import android.graphics.Outline
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atividade01dm.ui.viewModel.AuthViewModel


@Composable
fun LoginScreen(){
    val viewModel = viewModel<AuthViewModel>()

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf("") }


    Surface (
        modifier = Modifier
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            if(!errorMessage.isNullOrBlank()) {
                Row {
                    Text(
                        text = errorMessage,
                        modifier = Modifier,
                        fontSize = 16.sp
                    )
                }
            }

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = senha,
                onValueChange = {senha = it},
                label = { Text(text = "Senha")},
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            Button(
                onClick = {
                    viewModel.login(
                        user = email,
                        senha = senha,
                        onSuccess = { },
                        onError = {message ->
                            errorMessage = message
                        }

                    )
                }
            ) {
                Text(text = "Logar")
            }


        }
    }
}
