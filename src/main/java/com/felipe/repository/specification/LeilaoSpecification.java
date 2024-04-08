package com.felipe.repository.specification;

import com.felipe.entity.Leilao;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class LeilaoSpecification implements Specification<Leilao> {

    private Integer codigo;
    private String razaoSocialVendedor;
    private Instant inicioPrevistoInicio;
    private Instant inicioPrevistoFim;

    @Override
    public Predicate toPredicate(Root<Leilao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(this.codigo)) {
            predicates.add(criteriaBuilder.equal(root.get("codigo"), this.codigo));
        }
        if (StringUtils.isNotEmpty(this.razaoSocialVendedor)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("vendedor").get("razaoSocial")), "%" + this.razaoSocialVendedor.toLowerCase() + "%"));
        }
        if (Objects.nonNull(this.inicioPrevistoInicio) && Objects.nonNull(this.inicioPrevistoFim)) {
            predicates.add(criteriaBuilder.between(root.get("inicioPrevisto"), this.inicioPrevistoInicio, this.inicioPrevistoFim));
        }
        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
    }
}
