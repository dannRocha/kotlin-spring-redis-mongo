package com.br.turdus.repository

import com.br.turdus.core.domain.User

interface UserRepository {
    fun findAllUsers(): List<User>
    fun createUser(user: User): User
}