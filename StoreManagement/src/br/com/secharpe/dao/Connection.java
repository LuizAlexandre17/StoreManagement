package br.com.secharpe.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.secharpe.util.Log;

/**
 * Classe para acesso ao banco de dados
 *
 * @author luandr <stringigualanull@outlook.com>
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Connection {

    public static java.sql.Connection getConnection() {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/erpdb", "sa", "");
        } catch (SQLException e) {
            System.out.println("Problemas ao conectar no banco de dados");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            Log log = new Log();
            log.put("Connection", exceptionAsString);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi configurado corretametne");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            Log log = new Log();
            log.put("Connection", exceptionAsString);
        }

        return conn;
    }

}
