package com.br.turdus.cqr.publisher

interface Publisher<T, R>  {
    fun publish(content: T): R
}