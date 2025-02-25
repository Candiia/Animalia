package com.candi.animalia.query;

import com.candi.animalia.model.Usuario;
import com.candi.animalia.util.SearchCriteria;

import java.util.List;

public class UserSpecificationBuilder extends GenericSpecificationBuilder<Usuario>{

    public UserSpecificationBuilder(List<SearchCriteria> params) {
        super(params);
    }
}
