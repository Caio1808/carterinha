package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.core.network.NetworkClient
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.data.remote.service.UnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.login.data.remote.service.AuthApi
import com.senaisp.carteirinhadigital.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senaisp.carteirinhadigital.feature.login.data.repository.FakeAuthRepository
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.remote.service.UnidadeCurricularApi as ProfessorUnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl as ProfessorUnidadeCurricularRepositoryImpl
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository as ProfessorUnidadeCurricularRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient =
        NetworkClient(
            baseUrl = BASE_URL,
            sessionTokenStore = sessionTokenStore
        )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(
            AuthApi::class.java
        )
    }
    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            UnidadeCurricularApi::class.java
        )
    }
    private val professorUnidadeCurricularApi: ProfessorUnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            ProfessorUnidadeCurricularApi::class.java
        )
    }
    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(
                api = authApi
            )
        }
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }
    override val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository by lazy {
        ProfessorUnidadeCurricularRepositoryImpl(
            api = professorUnidadeCurricularApi
        )
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}
