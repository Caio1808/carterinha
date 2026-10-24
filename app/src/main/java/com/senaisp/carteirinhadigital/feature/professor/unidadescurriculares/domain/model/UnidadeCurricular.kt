package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.model

data class UnidadeCurricular(
    val id: String,
    val nome: String,
    val turmaId: String,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)
