package com.br.turdus.core.domain

import com.br.turdus.core.dto.user.UserDetailsDTO
import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val password: String,
    val email: String
)

inline val User.DTO: UserDetailsDTO
    get() = UserDetailsDTO(
            username = this.username,
            email = this.email
        )
