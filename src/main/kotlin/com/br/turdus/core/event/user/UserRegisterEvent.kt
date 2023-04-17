package com.br.turdus.core.event.user

import com.br.turdus.core.domain.User
import java.util.*

data class UserRegisterEvent(
        val username: String,
        val password: String,
        val email: String,
)

inline val UserRegisterEvent.Domain: User
    get() = User(
            id = UUID.randomUUID(),
            username = this.username,
            password = this.password,
            email = this.email,
        )

