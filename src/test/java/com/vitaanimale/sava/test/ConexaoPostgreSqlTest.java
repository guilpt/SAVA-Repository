package com.vitaanimale.sava.test;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elisa
 */
public class ConexaoPostgreSqlTest {

    private Connection connection;

    @BeforeClass
    public static void setUpClass() throws Exception {
        Class.forName("org.postgresql.Driver");
    }

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBSAVA", "postgres", "@nimale");
    }

    @After
    public void tearDown() throws Exception{
        connection.close();
    }

    @Test
    public void hello() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();

            rs = stmt.executeQuery("SELECT * FROM va_clientes");

            while (rs.next()) {
                Integer idCliente = rs.getInt("id_cliente");
                String nomeCliente = rs.getString("nome_cliente");

                System.out.println(idCliente + "\t - \t" + nomeCliente);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        }

        assertTrue(true);
    }
}
