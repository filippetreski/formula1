package com.example.demo.services;

import com.example.demo.utils.QueryUtil;
import org.springframework.stereotype.Service;

@Service
public class FormulaOneService {

    public String getAbstract(String language) {
        String query = "select ?abstract where {dbr:Formula_One dbo:abstract ?abstract. filter (lang (?abstract) = \""+language+"\")}";
        String url = QueryUtil.getURLWithQuery(query);
       return QueryUtil.getResultFromQuery(url);
    }
}

