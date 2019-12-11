package com.example.simplefirebasechat.domain.authinteractor

import com.example.simplefirebasechat.data.repositories.authrepository.IUserRepository
import io.reactivex.Completable
import javax.inject.Inject

class AuthInteractorImpl @Inject constructor(
    private val userRepository: IUserRepository
) : IAuthInteractor {

    override fun login(email: String, password: String): Completable {
        return userRepository.login(email, password)
    }

    override fun register(email: String, password: String): Completable {
        return userRepository.register(email, password)
    }

    override fun logout() {
        return userRepository.logout()
    }
}