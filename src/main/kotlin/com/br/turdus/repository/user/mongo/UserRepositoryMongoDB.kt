package com.br.turdus.repository.user.mongo

import com.br.turdus.core.domain.User
import com.br.turdus.repository.UserRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepositoryMongoDB : UserRepository, MongoRepository<User, UUID> {

}