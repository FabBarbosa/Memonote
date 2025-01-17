package com.fabbarbosa.notebook.domain.nota;

import com.fabbarbosa.notebook.domain.Enums.Status_nota;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroNota(

        String titulo,

        String texto_nota,

        @NotNull
        Status_nota status_nota
) {
}