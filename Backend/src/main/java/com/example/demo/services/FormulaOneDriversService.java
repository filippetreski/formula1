package com.example.demo.services;

import com.example.demo.utils.QueryUtil;
import org.springframework.stereotype.Service;

@Service
public class FormulaOneDriversService {

    public String getHomePageDrivers(Integer limit, String language) {
        /*
         * This query is designed to ordering by podiums but this can easily be changed, it should be discussed!
         *  TODO discuss with team about ordering!
         */
        String query = "select ?subject ?name ?comment ?thumbnail\n" +
                "where {\n" +
                "?subject rdf:type dbo:FormulaOneRacer.\n" +
                "?subject foaf:name ?name.\n" +
                "?subject rdfs:comment ?comment.\n" +
                "?subject dbo:podiums ?podiums. \n" +
                "?subject dbo:thumbnail ?thumbnail \n" +
                "filter(lang(?name) = \"" + language + "\" && lang(?comment) = \"" + language + "\")\n" +
                "}\n" +
                "order by desc(?podiums)" +
                "limit " + limit.toString();
        return QueryUtil.getResultFromQuery(query);
    }
}
