package com.br.turdus.core.dto.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserDetailsDTO(
    val username: String,
    val email: String
)