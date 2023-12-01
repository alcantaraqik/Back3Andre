package com.backEnd.matheus.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Produto implements Serializable {

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoDetalhe getProdutoDetalhe() {
        return produtoDetalhe;
    }

    public void setProdutoDetalhe(ProdutoDetalhe produtoDetalhe) {
        this.produtoDetalhe = produtoDetalhe;
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_detalhe_id", referencedColumnName = "id")
    ProdutoDetalhe produtoDetalhe;

    @ManyToMany
    Set<Venda> vendas;

}
