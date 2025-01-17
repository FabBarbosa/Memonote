package com.fabbarbosa.notebook.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(

    @NotBlank
    String titulo_categoria,

    String descricao_categoria
) {


} 