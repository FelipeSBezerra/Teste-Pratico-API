package com.felipe.repository;

import com.felipe.entity.Comprador;
import com.felipe.entity.pk.CompradorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompradorRepository extends JpaRepository<Comprador, CompradorId> {
}
