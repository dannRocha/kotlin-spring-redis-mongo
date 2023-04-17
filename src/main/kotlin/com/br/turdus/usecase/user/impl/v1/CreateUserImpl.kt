package com.br.turdus.usecase.user.impl.v1

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import com.br.turdus.usecase.user.CreateUser

class CreateUserImpl(
    private val repository: UserRepository
) : CreateUser {
    override fun execute(user: User): User {

        var userExists = repository.findByEmail(user.email)

        if(userExists != null) {
            throw RuntimeException()
        }

        return repository.insert(user)
    }
}