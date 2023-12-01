package com.backEnd.matheus.repositories;

import com.backEnd.matheus.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {
    List<Venda> findByDocumentoContainsIgnoreCase (String documento);
}
