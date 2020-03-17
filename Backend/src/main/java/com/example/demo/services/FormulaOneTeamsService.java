package com.example.demo.services;


import com.example.demo.utils.QueryUtil;
import org.springframework.stereotype.Service;

@Service
public class FormulaOneTeamsService {

    public String getListOfTeams(Integer limit, String language) {

        String query = "SELECT (SAMPLE(?team) AS ?team) (SAMPLE(?name) AS ?name) (SAMPLE(?description) AS ?description)  (SAMPLE(?webPageLink) AS ?webLink) (SAMPLE(?constructorName) AS ?constructorName) (SAMPLE(?wins) AS ?wins)\n" +
                "WHERE { ?team rdf:type dbo:FormulaOneTeam .\n" +
                "?team rdfs:label ?name .\n" +
                "?team rdfs:comment ?description .\n" +
                "?team foaf:homepage ?webPageLink .\n" +
                "OPTIONAL {?team dbp:constructorName ?constructorName .}\n" +
                "OPTIONAL {?team dbp:wins ?wins .}\n" +
                "FILTER(lang(?name) = \"" + language + "\" && lang(?description) = \"" + language + "\")}\n" +
                "GROUP BY ?team \n" +
                "ORDER BY DESC(?wins) \n" +
                "LIMIT " + limit.toString();
        return QueryUtil.getResultFromQuery(query);
    }

    public String search(String name,String language,Integer limit) {

        String query= "SELECT (SAMPLE(?team) AS ?team) (SAMPLE(?name) AS ?name) (SAMPLE(?description) AS ?description)  (SAMPLE(?webpageLink) AS ?webLink) (SAMPLE(?constructorName) AS ?constructorName) (SAMPLE(?wins) AS ?wins)\n" +
                "WHERE { ?team rdf:type dbo:FormulaOneTeam .\n" +
                "?team rdfs:label ?name .\n" +
                "?team rdfs:comment ?description .\n" +
                "?team foaf:homepage ?webpageLink .\n" +
                "OPTIONAL {?team dbp:constructorName ?constructorName .}\n" +
                "OPTIONAL {?team dbp:wins ?wins .}\n" +
                "FILTER(lang(?name)=\"" + language + "\" && lang(?description) = \"" + language + "\" && contains(lcase(str(?name)),lcase(\"" + name + "\")))}\n" +
                "GROUP BY ?team\n" +
                "ORDER BY DESC(?wins)\n" +
                "LIMIT " + limit.toString();

        return QueryUtil.getResultFromQuery(query);
    }
}
