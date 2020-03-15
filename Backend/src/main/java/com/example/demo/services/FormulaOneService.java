package com.example.demo.services;

import com.example.demo.utils.QueryUtil;
import org.apache.jena.atlas.json.JSON;
import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.shared.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FormulaOneService {

    public String getAbstract(String language) {
        String query = "select ?abstract where {dbr:Formula_One dbo:abstract ?abstract. filter (lang (?abstract) = \"" + language + "\")}";
        JsonObject responseJson = JSON.parse(QueryUtil.getResultFromQuery(query));
        return responseJson.getObj("results").
                getArray("bindings")
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Bindings not found in abstract json"))
                .toString();
    }
}

