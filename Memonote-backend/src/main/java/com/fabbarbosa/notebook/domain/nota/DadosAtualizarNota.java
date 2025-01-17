package com.fabbarbosa.notebook.domain.nota;

import com.fabbarbosa.notebook.domain.Enums.Status_nota;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNota(
    @NotNull
    Long id,
    String titulo,
    String texto_nota,
    Status_nota status_nota

) {
} 