package com.candi.animalia.query;

import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Raza;
import com.candi.animalia.util.SearchCriteria;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Log
@AllArgsConstructor
public class MascotaSpecificationBuilder<U> {
    private List<SearchCriteria> params;


    public Specification<U> build() {
        if (params.size() == 0) {
            return null;
        }

        log.info("Adding first specification " + params.get(0));
        Specification<U> result = build(params.get(0));
        log.info("Specification: " + result.toString());

        for(int i = 1; i < params.size(); i++) {
            log.info("Adding new specification " + params.get(i));
            result = result.and(build(params.get(i)));
            log.info(result.toString());
            log.info("Specification: " + result.toString());
        }

        log.info("Final Specification: " + result.toString());


        return result;
    }


    private Specification<U> build(SearchCriteria criteria) {
        return new Specification<U>() {
            @Override
            public Predicate toPredicate(Root<U> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                Predicate predicate = builder.conjunction();

                if (criteria.key().equalsIgnoreCase("especie")) {
                    Join<Mascota, Especie> especieJoin = root.join("especie");
                    if (criteria.operation().equalsIgnoreCase(":")) {
                        predicate = builder.and(predicate,
                                builder.equal(especieJoin.get("nombre"), criteria.value()));
                    } else if (criteria.operation().equalsIgnoreCase(">")) {
                        predicate = builder.and(predicate,
                                builder.greaterThanOrEqualTo(especieJoin.get("nombre"), criteria.value().toString()));
                    } else if (criteria.operation().equalsIgnoreCase("<")) {
                        predicate = builder.and(predicate,
                                builder.lessThanOrEqualTo(especieJoin.get("nombre"), criteria.value().toString()));
                    }
                }

                if (criteria.key().equalsIgnoreCase("raza")) {
                    Join<Mascota, Raza> razaJoin = root.join("raza"); 
                    if (criteria.operation().equalsIgnoreCase(":")) {
                        predicate = builder.and(predicate,
                                builder.equal(razaJoin.get("nombre"), criteria.value()));
                    } else if (criteria.operation().equalsIgnoreCase(">")) {
                        predicate = builder.and(predicate,
                                builder.greaterThanOrEqualTo(razaJoin.get("nombre"), criteria.value().toString()));
                    } else if (criteria.operation().equalsIgnoreCase("<")) {
                        predicate = builder.and(predicate,
                                builder.lessThanOrEqualTo(razaJoin.get("nombre"), criteria.value().toString()));
                    }

                }

                if (criteria.key().equalsIgnoreCase("nombre")) {
                    if (criteria.operation().equalsIgnoreCase(":")) {
                        predicate = builder.and(predicate,
                                builder.equal(root.get("nombre"), criteria.value()));
                    } else if (criteria.operation().equalsIgnoreCase(">")) {
                        predicate = builder.and(predicate,
                                builder.greaterThanOrEqualTo(root.get("nombre"), criteria.value().toString()));
                    } else if (criteria.operation().equalsIgnoreCase("<")) {
                        predicate = builder.and(predicate,
                                builder.lessThanOrEqualTo(root.get("nombre"), criteria.value().toString()));
                    }
                }

                return predicate;
            }
        };
    }


    private SearchCriteria findSearchCriteria(String key) {
        for (SearchCriteria sc : params) {
            if (sc.key().equalsIgnoreCase(key)) {
                return sc;
            }
        }
        return null;
    }



}
