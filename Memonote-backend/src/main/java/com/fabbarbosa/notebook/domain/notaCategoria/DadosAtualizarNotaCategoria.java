package com.fabbarbosa.notebook.domain.notaCategoria;

import com.fabbarbosa.notebook.domain.categoria.Categoria;
import com.fabbarbosa.notebook.domain.nota.Nota;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarNotaCategoria(
    @NotNull
    Long id,
    Nota id_nota,
    Categoria id_categoria
) {
}