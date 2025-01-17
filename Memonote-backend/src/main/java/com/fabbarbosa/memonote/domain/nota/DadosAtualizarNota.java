package com.fabbarbosa.memonote.domain.nota;

import com.fabbarbosa.memonote.domain.Enums.Status_nota;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNota(
    @NotNull
    Long id,
    String titulo,
    String texto_nota,
    Status_nota status_nota

) {
} 