package com.fabbarbosa.memonote.domain.notaCategoria;

import com.fabbarbosa.memonote.domain.categoria.Categoria;
import com.fabbarbosa.memonote.domain.nota.Nota;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNotaCategoria(
    @NotNull
    Long id,
    Nota id_nota,
    Categoria id_categoria
) {
}