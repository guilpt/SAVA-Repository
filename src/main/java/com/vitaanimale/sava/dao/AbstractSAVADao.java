package com.vitaanimale.sava.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Elisa
 */
public class AbstractSAVADao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    
}
