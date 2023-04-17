package com.br.turdus.config.di

import com.br.turdus.core.dto.user.UserCreateDTO
import com.br.turdus.core.event.user.UserRegisterEvent
import com.br.turdus.core.utils.message.PIDMessage
import com.br.turdus.cqr.publisher.Publisher
import com.br.turdus.cqr.publisher.user.UserRegisterPublisher
import com.br.turdus.cqr.subscriber.Subscriber
import com.br.turdus.cqr.subscriber.user.UserRegisterSubscriber
import com.br.turdus.repository.UserRepository
import com.br.turdus.repository.user.UserRepositoryInMemory
import com.br.turdus.usecase.user.CreateUser
import com.br.turdus.usecase.user.FindAllUsers
import com.br.turdus.usecase.user.impl.v1.CreateUserImpl
import com.br.turdus.usecase.user.impl.v1.FindAllUsersImpl
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

object UserDIImpl {
    object V1 {
        const val SUBSCRIBER_REGISTER_DI: String = "userRegisterSubscriber:v1"
        const val PUBLISHER_REGISTER_DI: String = "userRegisterPublisher:v1"
        const val USE_CASE_CREATE_USER_DI: String = "createUserUseCase:v1"
        const val USE_CASE_FIND_ALL_USERS: String = "findAllUsersUseCase:v1"
        const val REPOSITORY_USER_DI: String = "userRepository:v1"
        const val REPOSITORY_USER_IN_MEMORY: String = "userRepositoryInMemory:v1"

    }
}


@Configuration
class UserDI(
    private val applicationEventPublisher : ApplicationEventPublisher
) {

    private val userRepositoryImMemory: UserRepository = UserRepositoryInMemory();


    @Bean(UserDIImpl.V1.SUBSCRIBER_REGISTER_DI)
    fun userRegisterSubscriber() : Subscriber<UserRegisterEvent> {
        return UserRegisterSubscriber(
            createUserUserCase()
        )
    }

    @Bean(UserDIImpl.V1.PUBLISHER_REGISTER_DI)
    fun userRegisterPublish(): Publisher<UserCreateDTO, PIDMessage> {
        return UserRegisterPublisher(applicationEventPublisher);
    }

    @Bean(UserDIImpl.V1.USE_CASE_CREATE_USER_DI)
    fun createUserUserCase(): CreateUser {
        return CreateUserImpl(userRepositoryImMemory)
    }


    @Bean(UserDIImpl.V1.USE_CASE_FIND_ALL_USERS)
    fun findAllUser(): FindAllUsers {
        return FindAllUsersImpl(userRepositoryImMemory)
    }

    @Bean(UserDIImpl.V1.REPOSITORY_USER_IN_MEMORY)
    fun userRepository(): UserRepository {
        return userRepositoryImMemory
    }
}