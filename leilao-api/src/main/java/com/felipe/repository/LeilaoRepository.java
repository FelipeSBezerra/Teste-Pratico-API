package com.felipe.repository;

import com.felipe.entity.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer> {
}
