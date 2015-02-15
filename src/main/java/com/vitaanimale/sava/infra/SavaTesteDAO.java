package com.vitaanimale.sava.infra;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Elisa
 */
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/savaContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SavaTesteDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected JdbcTemplate jdcbcTemplate;
    
}
