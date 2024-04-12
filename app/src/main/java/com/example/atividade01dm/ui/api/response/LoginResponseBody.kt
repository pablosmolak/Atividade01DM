package com.example.atividade01dm.ui.api.response

import com.example.atividade01dm.ui.api.model.Usuario

data class LoginResponseBody (
    var token: String = "",
    var usuario: Usuario

)