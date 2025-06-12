    package com.candi.animalia.query;

    import com.candi.animalia.model.Especie;
    import com.candi.animalia.model.Mascota;
    import com.candi.animalia.model.Publicacion;
    import com.candi.animalia.model.Raza;
    import com.candi.animalia.util.SearchCriteria;
    import jakarta.persistence.criteria.*;
    import lombok.AllArgsConstructor;
    import lombok.extern.java.Log;
    import org.springframework.data.jpa.domain.Specification;

    import java.util.List;

    @Log
    @AllArgsConstructor
    public class PublicationSpecificationBuilder<U> {
        private List<SearchCriteria> params;


        public Specification<U> build() {
            if (params.isEmpty()) {
                return null;
            }

            Specification<U> result = build(params.get(0));

            for (int i = 1; i < params.size(); i++) {
                result = result.and(build(params.get(i)));
            }

            return result;
        }


        private Specification<U> build(SearchCriteria criteria) {
            return (root, query, cb) -> {
                Join<Publicacion, Mascota> mascotaJoin = root.join("mascota");
                Predicate predicate = cb.conjunction();
                if ("nombre".equalsIgnoreCase(criteria.key())) {
                    predicate = cb.and(predicate, cb.like(cb.lower(mascotaJoin.get("nombre")), "%" + criteria.value().toString().toLowerCase() + "%"));
                } else if ("especie".equalsIgnoreCase(criteria.key())) {
                    Join<Mascota, Especie> especieJoin = mascotaJoin.join("especie");
                    predicate = cb.and(predicate, cb.like(cb.lower(especieJoin.get("nombre")), "%" + criteria.value().toString().toLowerCase() + "%"));
                } else if ("raza".equalsIgnoreCase(criteria.key())) {
                    Join<Mascota, Raza> razaJoin = mascotaJoin.join("raza");
                    predicate = cb.and(predicate, cb.like(cb.lower(razaJoin.get("nombre")), "%" + criteria.value().toString().toLowerCase() + "%"));
                }

                return predicate;
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
