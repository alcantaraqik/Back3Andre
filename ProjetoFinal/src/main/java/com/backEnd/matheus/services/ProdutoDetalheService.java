package com.backEnd.matheus.services;

import com.backEnd.matheus.models.ProdutoDetalhe;
import com.backEnd.matheus.repositories.ProdutoDetalheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoDetalheService {
    @Autowired
    private ProdutoDetalheRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProdutoDetalhe> findAll() {
        return repository.findAll();
    }

    public Optional<ProdutoDetalhe> findById(ProdutoDetalhe produtoDetalhe,Long id) {
        return repository.findById(id);
    }

    public ProdutoDetalhe create(ProdutoDetalhe produtoDetalhe) { return repository.save(produtoDetalhe);}

    public ProdutoDetalhe update(ProdutoDetalhe produtoDetalhe){ return repository.save(produtoDetalhe);}

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<ProdutoDetalhe> buscarDetalheProduto(Long id){
        Query query = entityManager.createNativeQuery("select d.* from produto p" +
                "  join produtoDetalhe pd on p.id = pd.idProduto" +
                "  where p.id = " + id, "ProdutoDetalhesMapping");
        List<ProdutoDetalhe> produtoDetalhes = query.getResultList();
        return produtoDetalhes;
    }

}
