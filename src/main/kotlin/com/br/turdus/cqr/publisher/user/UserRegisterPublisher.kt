package com.br.turdus.cqr.publisher.user


import com.br.turdus.core.dto.user.Ev
import com.br.turdus.core.dto.user.UserCreateDTO
import com.br.turdus.core.utils.message.PIDMessage
import com.br.turdus.core.utils.message.StatusProcess
import com.br.turdus.cqr.publisher.Publisher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.context.ApplicationEventPublisher
import java.util.*

class UserRegisterPublisher(
    private val publisher: ApplicationEventPublisher
) : Publisher<UserCreateDTO, PIDMessage> {

    override fun publish(user: UserCreateDTO): PIDMessage {
        val pid = UUID.randomUUID();


        CoroutineScope(Dispatchers.IO).launch {
            publisher.publishEvent(user.Ev)
            delay(1000)
        }

        return PIDMessage(
            message = "processing create user request",
            status = StatusProcess.PENDING,
            pid = pid
        )
    }
}