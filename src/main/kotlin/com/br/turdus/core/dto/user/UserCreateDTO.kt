package com.br.turdus.core.dto.user

import com.br.turdus.core.event.user.UserRegisterEvent
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserCreateDTO(
        @NotBlank val username: String,
        @NotBlank val password: String,
        @NotBlank @Email val email: String
)

inline val UserCreateDTO.Ev: UserRegisterEvent
    get() = UserRegisterEvent(
            username = this.username,
            password = this.password,
            email = this.email,
    )
