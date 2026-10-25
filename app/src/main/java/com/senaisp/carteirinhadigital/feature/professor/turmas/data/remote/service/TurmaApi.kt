package com.senaisp.carteirinhadigital.feature.professor.turmas.data.remote.service

import com.senaisp.carteirinhadigital.feature.professor.turmas.data.remote.dto.TurmaDto
import retrofit2.http.GET

interface TurmaApi {

    @GET("professores/me/turmas")
    suspend fun listar(): List<TurmaDto>
}
