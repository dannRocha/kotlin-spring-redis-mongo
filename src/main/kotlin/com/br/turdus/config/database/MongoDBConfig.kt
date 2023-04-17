package com.br.turdus.config.database

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoClientFactoryBean


@Configuration
class MongoDBConfig {

    private val host: String = "localhost"
    private val port: Int = 27017
    private var appname: String = "TurdusUser"
    @Bean
    fun clientFactory(): MongoClientFactoryBean? {
        val mongo = MongoClientFactoryBean()
        mongo.apply {
            this.setHost(host)
            this.setPort(port)
        }
        return mongo
    }

}