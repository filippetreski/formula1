package com.example.demo.services;

import com.example.demo.utils.QueryUtil;
import org.springframework.stereotype.Service;

@Service
public class FormulaOneDriversService {

    public String getListOfDrivers(Integer limit, String language) {
        /*
         * This query is designed to ordering by points but this can easily be changed, it should be discussed!
         *  TODO discuss with team about ordering!
         */
        String query = "select ?subject ?name ?comment ?thumbnail ?points\n" +
                "where {\n" +
                "?subject rdf:type dbo:FormulaOneRacer.\n" +
                "?subject foaf:name ?name.\n" +
                "?subject rdfs:comment ?comment.\n" +
                "?subject dbp:points ?points. \n" +
                "?subject dbo:thumbnail ?thumbnail \n" +
                "filter(lang(?name) = \"" + language + "\" && lang(?comment) = \"" + language + "\")\n" +
                "}\n" +
                "order by desc(?points)" +
                "limit " + limit.toString();
        return QueryUtil.getResultFromQuery(query);
    }

    public String getDriverDetails(String name, String language) {
        //THIS QUERY TAKES TOO MUCH TIME AND MUST BE SIMPLIFIED
        //TODO SIMPLIFY THIS QUERY!
        String query = "select ?subject \"Michael Schumacher\" as ?name ?thumbnail ?birthDate ?birthPlace ?points\n" +
                "?numChampionships ?fastestLap ?firstRace ?firstWin ?lastRace ?lastWin ?numPodiums\n" +
                "?numRaces ?numPoles ?wins ?nationality ?points ?championship ?deathDate ?quote ?abstract\n" +
                "where {\n" +
                "?subject rdf:type dbo:FormulaOneRacer;\n" +
                "         foaf:name ?name;\n" +
                "         dbo:abstract ?abstract;\n" +
                "         dbo:podiums ?podiums;\n" +
                "         dbp:points ?points;\n" +
                "         dbo:thumbnail ?thumbnail;\n" +
                "         dbo:birthDate ?birthDate;\n" +
                "         dbo:birthPlace ?birthPlace;\n" +
                "         dbo:championships ?numChampionships;\n" +
                "         dbo:fastestLap ?fastestLap;\n" +
                "         dbo:firstRace ?firstRace;\n" +
                "         dbo:firstWin ?firstWin;\n" +
                "         dbo:lastRace ?lastRace;\n" +
                "         dbo:lastWin ?lastWin;\n" +
                "         dbo:podiums ?numPodiums;\n" +
                "         dbo:races ?numRaces;\n" +
                "         dbo:poles ?numPoles;\n" +
                "         dbo:wins ?wins;\n" +
                "         dbp:nationality ?nationality;\n" +
                "         dbp:points ?points;\n" +
                "         dbo:firstDriver ?championship.\n" +
                "    OPTIONAL { ?subject dbo:deathDate ?deathDate.}\n" +
                "    OPTIONAL { ?subject dbp:quote ?quote. }\n" +
                "                  \n" +
                "filter(lang(?name) = \"en\" && lang(?abstract) = \"en\")\n" +
                "}\n" +
                "order by desc(?points)\n" +
                "limit 1";
        return QueryUtil.getResultFromQuery(query);
    }
}
