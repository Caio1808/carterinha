package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.component

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
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
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
                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Turma: ${unidadeCurricular.turma}",
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Aulas: ${unidadeCurricular.aulasRealizadas}/${unidadeCurricular.quantidadeAulas}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${unidadeCurricular.cargaHoraria}h",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            if (unidadeCurricular.diasSemana.isNotEmpty()) {
                Text(
                    text = "${unidadeCurricular.diasSemana.joinToString(", ")} (${unidadeCurricular.horarioInicio} - ${unidadeCurricular.horarioFim})",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnidadeCurricularCardPreview() {
    UnidadeCurricularCard(
        unidadeCurricular = UnidadeCurricular(
            id = "1",
            nome = "Programação para Dispositivos Móveis",
            turmaId = "1",
            turma = "2DEVEST-A",
            cargaHoraria = 75,
            quantidadeAulas = 100,
            aulasRealizadas = 40,
            diasSemana = listOf("SEGUNDA", "QUARTA"),
            horarioInicio = "19:00",
            horarioFim = "22:30"
        )
    )
}
