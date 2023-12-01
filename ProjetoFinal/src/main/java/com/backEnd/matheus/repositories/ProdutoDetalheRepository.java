package com.backEnd.matheus.repositories;

import com.backEnd.matheus.models.ProdutoDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDetalheRepository extends JpaRepository<ProdutoDetalhe,Long> {
}
