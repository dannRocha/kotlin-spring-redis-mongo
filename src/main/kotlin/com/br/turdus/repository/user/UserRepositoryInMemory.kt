package com.br.turdus.repository.user

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import org.springframework.stereotype.Component


class UserRepositoryInMemory : UserRepository {
    private val repo = mutableListOf<User>()

    override fun findAllUsers(): List<User> = repo;

    override fun createUser(user: User): User {
        repo.add(user)
        return user;
    }
}