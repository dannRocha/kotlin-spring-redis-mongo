package com.br.turdus.controller

import com.br.turdus.config.di.UserDIImpl
import com.br.turdus.core.domain.DTO
import com.br.turdus.core.dto.user.UserCreateDTO
import com.br.turdus.core.dto.user.UserDetailsDTO
import com.br.turdus.core.utils.message.PIDMessage
import com.br.turdus.cqr.publisher.Publisher
import com.br.turdus.usecase.user.FindAllUsers
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class UserController(
    @Qualifier(UserDIImpl.V1.PUBLISHER_REGISTER_DI) val userRegisterPublisher: Publisher<UserCreateDTO, PIDMessage>,
    @Qualifier(UserDIImpl.V1.USE_CASE_FIND_ALL_USERS) val findAllUsers: FindAllUsers
) {

    @PostMapping
    fun createUser(@RequestBody user: UserCreateDTO) =
        ResponseEntity.ok(userRegisterPublisher.publish(user))

    @GetMapping
    fun getUsers(): ResponseEntity<List<UserDetailsDTO>> =
        ResponseEntity.ok(findAllUsers.execute().map { it.DTO })

    
}