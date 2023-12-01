package com.backEnd.matheus.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(
        name="ProdutoDetalhesMapping",
        classes={
                @ConstructorResult(
                        targetClass=Produto.class,
                        columns={
                                @ColumnResult(name="idProduto", type=Integer.class),
                                @ColumnResult(name="nome", type=String.class)})})

public class ProdutoDetalhe implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "produtoDetalhe")
    private Produto produto;

    private double valorCompra;
    private double valorVenda;
    private String dataVencimento;


}
