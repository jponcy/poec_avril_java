
package fr.tact.poecjava.courses.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import fr.tact.poecjava.courses.jdbc.entity.TchuTchu;

public class Main {

    /*
     * CREATE DATABASE poec_tchu_tchu;
     * CREATE TABLE train ( id INT(16) AUTO_INCREMENT NOT NULL PRIMARY KEY, name VARCHAR(255) NOT NULL UNIQUE, passager_nb INT(5) DEFAULT NULL) ENGINE=InnoDB;
     * INSERT INTO train (name, passager_nb) VALUES ('transibérien', 5543), ('213F3', NULL), ('train3', NULL), ('train4', 35);
     */

    public static void main(String[] args) {
        List<TchuTchu> list = new ArrayList<>();

        try (
                Connection conn = createConnection();
                Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM train");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Integer maxPeopleNb = rs.getInt("passager_nb");

                list.add(new TchuTchu(id, name, maxPeopleNb));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Liste initialisée");

        System.out.println("Les trains disponibles sont :");

        for (TchuTchu tchutchu : list) {
            System.out.println("\t- " + tchutchu.getName() + " avec " +
                    tchutchu.getMapPeopleNb() + " places");
        }
    }

    /**
     * Returns a new initialized connection to our database.
     * @return
     */
    private static Connection createConnection() {
        Connection conn = null;
        MysqlDataSource dataSource = new MysqlDataSource();

        // Add settings about the data source.
        dataSource.setServerName("127.0.0.1");
        dataSource.setUser("root");
        dataSource.setPassword("jepreferepostgres");
        dataSource.setDatabaseName("poec_tchu_tchu");

        // Create the connection to our database.
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Problème avec la base de données : " + e.getMessage());
            System.exit(-2);
        }

        return conn;
    }
}
