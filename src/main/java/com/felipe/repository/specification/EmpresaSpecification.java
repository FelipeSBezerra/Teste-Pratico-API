package com.felipe.repository.specification;

import com.felipe.entity.Empresa;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmpresaSpecification implements Specification<Empresa> {

    private String razaoSocial;
    private String cnpj;
    private String bairro;
    private String cep;

    @Override
    public Predicate toPredicate(Root<Empresa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotEmpty(this.razaoSocial)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("razaoSocial")), "%" + this.razaoSocial.toLowerCase() + "%"));
        }
        if (StringUtils.isNotEmpty(this.cnpj)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("cnpj")), "%" + this.cnpj.toLowerCase() + "%"));
        }
        if (StringUtils.isNotEmpty(this.bairro)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("bairro")), "%" + this.bairro.toLowerCase() + "%"));
        }
        if (StringUtils.isNotEmpty(this.cep)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("cep")), "%" + this.cep.toLowerCase() + "%"));
        }
        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
    }
}
