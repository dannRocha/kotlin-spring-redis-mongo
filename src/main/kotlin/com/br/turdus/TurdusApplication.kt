package com.br.turdus

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.br.turdus.repository"])
@EnableAsync
class TurdusApplication

fun main(args: Array<String>) {
	runApplication<TurdusApplication>(*args)
}
