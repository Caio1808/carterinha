package com.senaisp.carteirinhadigital.feature.professor.turmas.domain.repository

import com.senaisp.carteirinhadigital.feature.professor.turmas.domain.model.Turma

interface TurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}
