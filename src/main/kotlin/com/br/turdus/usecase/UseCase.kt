package com.br.turdus.usecase

interface UseCase<T, R> {
    fun execute(content: T?): R
}