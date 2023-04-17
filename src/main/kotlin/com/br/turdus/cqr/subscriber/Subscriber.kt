package com.br.turdus.cqr.subscriber

interface Subscriber<T> {
    fun execute(event: T)
}