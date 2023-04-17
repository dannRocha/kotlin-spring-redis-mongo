package com.br.turdus.cqr.publisher.user


import com.br.turdus.core.dto.user.Ev
import com.br.turdus.core.dto.user.UserCreateDTO
import com.br.turdus.core.utils.message.PIDMessage
import com.br.turdus.core.utils.message.StatusProcess
import com.br.turdus.cqr.publisher.Publisher
import org.springframework.context.ApplicationEventPublisher
import java.util.*


class UserRegisterPublisher(
    private val publisher: ApplicationEventPublisher
) : Publisher<UserCreateDTO, PIDMessage> {

    override fun publish(user: UserCreateDTO): PIDMessage {
        val pid = UUID.randomUUID();

        publisher.publishEvent(user.Ev)

        return PIDMessage(
            message = "processing create user request",
            status = StatusProcess.PENDING,
            pid = pid
        )
    }
}