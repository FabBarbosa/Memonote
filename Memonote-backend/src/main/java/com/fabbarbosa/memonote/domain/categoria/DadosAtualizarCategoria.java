package com.fabbarbosa.memonote.domain.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCategoria(
    @NotNull
    Long id,
    
    String titulo_categoria,
    String descricao_categoria
) {

    
}