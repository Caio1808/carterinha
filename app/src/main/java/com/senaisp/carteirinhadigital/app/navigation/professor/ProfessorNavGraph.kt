package com.senaisp.carteirinhadigital.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senaisp.carteirinhadigital.app.navigation.GraphRoutes
import com.senaisp.carteirinhadigital.app.navigation.ProfileGuard
import com.senaisp.carteirinhadigital.app.ui.AppShell
import com.senaisp.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.login.domain.model.PerfilAcesso
import com.senaisp.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.senaisp.carteirinhadigital.feature.professor.home.presentation.screen.HomeProfessorScreen
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    darkTheme: Boolean,
    unidadeCurricularRepository: UnidadeCurricularRepository,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {
        composable(route = ProfessorRoutes.HOME) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = {},
                        onUnidadesCurricularesClick = {
                            navController.navigate(ProfessorRoutes.UNIDADES_CURRICULARES)
                        },
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
