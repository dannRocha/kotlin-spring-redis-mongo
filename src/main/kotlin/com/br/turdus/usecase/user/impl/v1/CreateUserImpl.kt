package com.br.turdus.usecase.user.impl.v1

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import com.br.turdus.usecase.user.CreateUser

class CreateUserImpl(
//        @Qualifier(UserDIVersion.REPOSITORY_USER_IN_MEMORY_v1) private val repository: UserRepository
    private val repository: UserRepository
) : CreateUser {
    override fun execute(user: User): User = repository.createUser(user)
}