package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.remote.service

import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("professores/me/unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularDto>
}
