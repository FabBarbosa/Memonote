package com.fabbarbosa.memonote.domain.categoria;

public record DadosListagemCategoria(
    Long id,
    String Titulo_categoria,
    String descricao_categoria
) {
    public DadosListagemCategoria(Categoria categoria){
        this(
            categoria.getId(),
            categoria.getTitulo_categoria(),
            categoria.getDescricao_categoria()
        );
    }
}
