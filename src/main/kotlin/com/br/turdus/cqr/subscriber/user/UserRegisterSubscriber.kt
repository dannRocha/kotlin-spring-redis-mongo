package com.br.turdus.cqr.subscriber.user

import com.br.turdus.core.event.user.Domain
import com.br.turdus.core.event.user.UserRegisterEvent
import com.br.turdus.cqr.subscriber.Subscriber
import com.br.turdus.usecase.user.CreateUser

class UserRegisterSubscriber(
    private val createUser: CreateUser
) : Subscriber<UserRegisterEvent> {


    override fun execute(event: UserRegisterEvent) {
        createUser.execute(event.Domain)
    }
}