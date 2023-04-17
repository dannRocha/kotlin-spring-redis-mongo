package com.br.turdus.cqr.subscriber

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync

interface Subscriber<T> {
    @EventListener
    fun execute(event: T)

}