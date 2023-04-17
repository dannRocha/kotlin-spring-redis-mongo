package com.br.turdus.core.domain

import com.br.turdus.core.dto.user.UserDetailsDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
data class User(
    @Id val id: UUID,
    val username: String,
    val password: String,
    val email: String
)

inline val User.DTO: UserDetailsDTO
    get() = UserDetailsDTO(
            username = this.username,
            email = this.email
        )
