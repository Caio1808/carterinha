package com.senaisp.carteirinhadigital.app.di

import com.senaisp.carteirinhadigital.core.auth.SessionTokenStore
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository as ProfessorUnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository
}
