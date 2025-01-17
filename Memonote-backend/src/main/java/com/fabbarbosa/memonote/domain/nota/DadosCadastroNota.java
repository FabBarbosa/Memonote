package com.fabbarbosa.memonote.domain.nota;

import com.fabbarbosa.memonote.domain.Enums.Status_nota;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroNota(

        String titulo,

        String texto_nota,

        @NotNull
        Status_nota status_nota
) {
}