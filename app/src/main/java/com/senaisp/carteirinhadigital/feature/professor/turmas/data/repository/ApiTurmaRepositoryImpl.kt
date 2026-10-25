package com.senaisp.carteirinhadigital.feature.professor.turmas.data.repository

import com.senaisp.carteirinhadigital.feature.professor.turmas.data.remote.service.TurmaApi
import com.senaisp.carteirinhadigital.feature.professor.turmas.domain.model.Turma
import com.senaisp.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaRepository
import retrofit2.HttpException
import java.io.IOException

class ApiTurmaRepositoryImpl(
    private val api: TurmaApi
) : TurmaRepository {

    override suspend fun listar(): Result<List<Turma>> {
        return runCatching {
            api.listar().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar turmas (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar turmas.")
            }
        }
    }
}
