package com.br.turdus.repository.user.inmemory

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import org.springframework.stereotype.Component


class UserRepositoryInMemory : UserRepository {
    private val repo = mutableListOf<User>()

    override fun findAll(): List<User> = repo;

    override fun insert(user: User): User {
        repo.add(user)
        return user;
    }

    override fun findByEmail(email: String): User? {
        TODO("Not yet implemented")
    }
}