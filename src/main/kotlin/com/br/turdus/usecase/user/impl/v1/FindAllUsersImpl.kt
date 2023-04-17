package com.br.turdus.usecase.user.impl.v1

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import com.br.turdus.usecase.user.FindAllUsers

class FindAllUsersImpl(
   private val repository: UserRepository
) : FindAllUsers{
    override fun execute(): List<User> = repository.findAll()

}