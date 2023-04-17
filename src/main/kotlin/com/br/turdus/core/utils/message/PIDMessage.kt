package com.br.turdus.core.utils.message

import com.br.turdus.core.dto.user.UserCreateDTO
import com.br.turdus.core.event.user.UserRegisterEvent
import java.util.*

data class PIDMessage(
        val message: String,
        val status: StatusProcess,
        val pid: UUID,
)


inline val PIDMessage.Pending: PIDMessage
    get() = PIDMessage(
        message = "",
        status = StatusProcess.PENDING,
        pid = UUID.randomUUID()
    )