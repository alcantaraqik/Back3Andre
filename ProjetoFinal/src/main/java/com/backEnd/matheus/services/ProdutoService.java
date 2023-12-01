package com.backEnd.matheus.services;

import com.backEnd.matheus.dto.ProdutoDTO;
import com.backEnd.matheus.models.Produto;
import com.backEnd.matheus.models.ProdutoDetalhe;
import com.backEnd.matheus.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public List<Produto> listPorNome(String nome){
        return  repository.findByNomeContainsIgnoreCase(nome);
    }

    public Produto create(Produto produto) { return repository.save(produto);}

    public Produto update(Produto produto){ return repository.save(produto);}

    public void delete(Long id){
        repository.deleteById(id);
    }


    public List<ProdutoDTO>  getProdutosComAltoLucro() {

        try{
            List<Produto> produtos = repository.findAll();
            if (!produtos.isEmpty()) {
                ProdutoDTO produtoDTO = new ProdutoDTO();
                List<ProdutoDTO> produtoDTOS = new ArrayList<>();
                produtos.stream().forEach(produto -> {

                    ProdutoDetalhe produtoDetalhe = produto.getProdutoDetalhe();

                    if(produtoDetalhe != null){

                        if ((produtoDetalhe.getValorCompra() - produtoDetalhe.getValorVenda()) >= 50) {

                            produtoDTO.setNome(produtoDetalhe.getProduto().getNome());
                            produtoDTO.setValorVenda(produtoDetalhe.getValorVenda());
                            produtoDTO.setValorCompra(produtoDetalhe.getValorCompra());

                            produtoDTOS.add(produtoDTO);
                        };
                    }

                });

                return produtoDTOS;

            }
        }catch (Exception exception){
            exception.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existem produtos, com lucro alto, cadastrados.");
        }

        return new ArrayList<ProdutoDTO>();
    }

}
