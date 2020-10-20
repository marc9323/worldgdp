package com.luv2code.worldgdp.dao;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Setter
public class CountryDAO {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Queries
    private static final String SELECT_CLAUSE = "SELECT "
            + "c.code, "
            + "c.Name, "
            + "c.Continent, "
            + "c.region, "
            + "c.SurfaceArea surface_area, "
            + "c.IndepYear indep_year, "
            + "c.Population, "
            + "c.LifeExpectancy life_expectancy, "
            + "c.GNP, "
            + "c.LocalName local_name, "
            + "c.GovernmentForm government_form, "
            + "c.HeadOfState head_of_state, "
            + "c.code2, "
            + "c.capital,"
            + "cy.name capital_name "
            + "FROM country c"
            + "LEFT OUTER JOIN city ON cy.id = c.capital ";

    private static final String SEARCH_WHERE_CLAUSE = " AND ( LOWER(c.name) "
            + " LIKE CONCAT('%', LOWER(:search), '%'))";
}
