package com.br.turdus.repository

import com.br.turdus.core.domain.User
import java.util.Optional

interface UserRepository {
    fun findAll(): List<User>
    fun insert(user: User): User
    fun findByEmail(email: String): User?
}