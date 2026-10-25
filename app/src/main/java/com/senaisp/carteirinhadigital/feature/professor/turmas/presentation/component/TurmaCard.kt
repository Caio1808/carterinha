package com.senaisp.carteirinhadigital.feature.professor.turmas.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senaisp.carteirinhadigital.feature.professor.turmas.domain.model.Turma

@Composable
fun TurmaCard(
    modifier: Modifier = Modifier,
    turma: Turma
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = turma.codigo,
                style = MaterialTheme.typography.titleLarge
            )
            if (turma.curso.isNotEmpty()) {
                Text(
                    text = "Curso: ${turma.curso}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (turma.semestre.isNotEmpty()) {
                    Text(
                        text = "Semestre: ${turma.semestre}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = "Alunos: ${turma.quantidadeAlunos}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            if (turma.diasSemana.isNotEmpty()) {
                Text(
                    text = "${turma.diasSemana.joinToString(", ")} (${turma.horarioInicio} - ${turma.horarioFim})",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TurmaCardPreview() {
    TurmaCard(
        turma = Turma(
            id = "1",
            codigo = "2DEVEST-A",
            curso = "Desenvolvimento de Sistemas",
            semestre = "2026.2",
            quantidadeAlunos = 28,
            diasSemana = listOf("SEGUNDA", "QUARTA"),
            horarioInicio = "19:00",
            horarioFim = "22:30"
        )
    )
}
