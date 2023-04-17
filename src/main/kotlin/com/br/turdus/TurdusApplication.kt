package com.br.turdus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TurdusApplication

fun main(args: Array<String>) {
	runApplication<TurdusApplication>(*args)
}
