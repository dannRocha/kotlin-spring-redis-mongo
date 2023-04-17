package com.br.turdus.usecase.user

import com.br.turdus.core.domain.User

interface CreateUser {
    fun execute(user: User): User
}