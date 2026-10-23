package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.data.remote.dto

import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularDto(
    val id: String,
    val nome: String,
    val turmaId: String,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: Array<String>,
    val horarioInicio: String,
    val horarioFim: String
) {

    fun toDomain(): UnidadeCurricular {
        return UnidadeCurricular(
            id = id,
            nome = nome,
            turmaId = turmaId,
            turma = turma,
            cargaHoraria = cargaHoraria,
            quantidadeAulas = quantidadeAulas,
            aulasRealizadas = aulasRealizadas,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}