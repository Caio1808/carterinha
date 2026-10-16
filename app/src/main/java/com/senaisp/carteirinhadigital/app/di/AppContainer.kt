package com.senaisp.carteirinhadigital.app.di


import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : UnidadeCurricularRepository
}