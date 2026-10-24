package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository

import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar(): Result<List<UnidadeCurricular>>
}
