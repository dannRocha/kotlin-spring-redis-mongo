package com.br.turdus.cqr.subscriber.user

import com.br.turdus.core.event.user.Domain
import com.br.turdus.core.event.user.UserRegisterEvent
import com.br.turdus.cqr.subscriber.Subscriber
import com.br.turdus.usecase.user.CreateUser
import org.springframework.context.event.EventListener


class UserRegisterSubscriber(
//    @Qualifier(value = UserDIVersion.SUBSCRIBER_REGISTER_DI_V1)  private val createUser: CreateUser
    private val createUser: CreateUser
) : Subscriber<UserRegisterEvent> {

    @EventListener
    override fun execute(event: UserRegisterEvent) {
        createUser.execute(event.Domain)
    }
}