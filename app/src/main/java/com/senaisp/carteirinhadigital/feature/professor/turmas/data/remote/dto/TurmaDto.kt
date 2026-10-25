package com.senaisp.carteirinhadigital.feature.professor.turmas.data.remote.dto

import com.senaisp.carteirinhadigital.feature.professor.turmas.domain.model.Turma
import kotlinx.serialization.Serializable

@Serializable
data class TurmaDto(
    val id: String,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String> = emptyList(),
    val horarioInicio: String = "",
    val horarioFim: String = ""
) {

    fun toDomain(): Turma {
        return Turma(
            id = id,
            codigo = codigo,
            curso = curso,
            semestre = semestre,
            quantidadeAlunos = quantidadeAlunos,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}
