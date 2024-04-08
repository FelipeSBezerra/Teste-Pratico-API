package com.felipe.repository;

import com.felipe.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>, JpaSpecificationExecutor<Empresa> {

    Optional<Empresa> findByCnpj(String cnpj);
    Optional<Empresa> findByEmail(String email);
}
