package com.br.turdus.usecase.user

import com.br.turdus.core.domain.User

interface FindAllUsers {
    fun execute(): List<User>
}