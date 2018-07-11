
package fr.tact.poecjava.courses.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Strings;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import fr.tact.poecjava.courses.jdbc.entity.TchuTchu;

public class Main {

    /*
     * CREATE DATABASE poec_tchu_tchu;
     * CREATE TABLE train ( id INT(16) AUTO_INCREMENT NOT NULL PRIMARY KEY, name VARCHAR(255) NOT NULL UNIQUE, speed INT(5) NOT NULL, weight INT NOT NULL) ENGINE=InnoDB;
     * INSERT INTO train (name, speed, weight) VALUES ('transibérien', 5543, 103120432), ('213F3', 35, 215412), ('train3', 10, 103120432), ('train4', 35, 103120432), ('TTTGV', 54432, 103120432);
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TchuTchu> list = new ArrayList<>();
        Connection conn = createConnection();
        String id;
        TchuTchu o = new TchuTchu();

        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM train");

            while (rs.next()) {
                int trainId = rs.getInt("id");
                String nom = rs.getString("name");
                int vitesse = rs.getInt("speed");
                int poids = rs.getInt("weight");

                list.add(new TchuTchu(trainId, nom, vitesse, poids));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Liste initialisée");

        System.out.println("Les trains disponibles sont :");

        for (TchuTchu tchutchu : list) {
            System.out.println("\t- " + tchutchu);
        }

        String line;

        do {
            System.out.println("");
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1) ajouter un train");
            System.out.println("2) voir les détails d'un train");
            System.out.println("3) supprimer un train");
            System.out.println("4) modifier les informations d'un train");
            System.out.println("0) quitter l'application");

            while ("".equals(line = scanner.nextLine().trim()));

            switch (line) {
            case "0": // Leave soft.
                break;
            case "1": // Create.
                System.out.println("Quel nom ?");
                o.setNom(scanner.nextLine().trim());

                System.out.println("Quel est le poids (en Kg) ?");
                o.setPoids(Integer.parseInt(scanner.nextLine().trim()));

                System.out.println("Quel est la vitesse (en Km/h) ?");
                o.setVitesse(Integer.parseInt(scanner.nextLine()));

                try (Statement st = conn.createStatement()) {
                    st.executeUpdate(String.format("INSERT INTO train (name, speed, weight) VALUES ('%s', %d, %d)",
                            o.getNom(), o.getVitesse(), o.getPoids()));
                } catch (SQLException e1) {
                    // TODO: Check UNIQUE name.
                    e1.printStackTrace();
                }

                break;
            case "2": // Read details.
                System.out.print("Sur quel train ? (donner l'id) : ");
                while (!(id = scanner.nextLine().trim()).matches("^\\d+$"));

                try (Statement statement = conn.createStatement()) {
                    ResultSet rs = statement.executeQuery("SELECT * FROM train WHERE id = " + id);

                    if (rs.next()) {
                        o.setId(rs.getInt("id"));
                        o.setNom(rs.getString("name"));
                        o.setVitesse(rs.getInt("speed"));
                        o.setPoids(rs.getInt("weight"));

                        System.out.println("Détails du train (" + o.getId() + ") " + o.getNom());
                        System.out.println("id : " + o.getId());
                        System.out.println("nom : " + o.getNom());
                        System.out.println("vitesse : " + o.getVitesse());
                        System.out.println("poids : " + o.getPoids());
                    } else {
                        System.out.println("Train non trouvé pour l'id '" + id + "'");
                    }

                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println("Bientôt disponible !");
                break;
            case "4": // Update.
                System.out.print("Sur quel train ? (donner l'id) : ");
                while (!(id = scanner.nextLine().trim()).matches("^\\d+$"));

                try (Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM train WHERE id = " + id)) {
                    if (rs.next()) {
                        o.setId(rs.getInt("id"));
                        o.setNom(rs.getString("name"));
                        o.setVitesse(rs.getInt("speed"));
                        o.setPoids(rs.getInt("weight"));
                    } else {
                        System.err.println("Le train n'a pas été trouvé");
                        continue;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    continue;
                }

                System.out.println("Quel est le nom (" + o.getNom() + ") ?");
                line = scanner.nextLine().trim();
                if (!Strings.isNullOrEmpty(line)) {
                    o.setNom(line);
                }

                System.out.println("Quel est la vitesse du train " + o.getNom() + " (" + o.getVitesse() + ") ?");
                line = scanner.nextLine().trim();
                if (!Strings.isNullOrEmpty(line)) {
                    o.setVitesse(Integer.parseInt(line));
                }

                System.out.println("Quel est le poids du train " + o.getNom() + " (" + o.getPoids() + ") ?");
                line = scanner.nextLine().trim();
                if (!Strings.isNullOrEmpty(line)) {
                    o.setPoids(Integer.parseInt(line));
                }

                try (Statement st = conn.createStatement()) {
                    String sql = MessageFormat.format(
                            "UPDATE train SET name=''{0}'', speed={1}, weight={2} WHERE id = {3}",
                            o.getNom(),
                            Integer.toString(o.getVitesse()),
                            Integer.toString(o.getPoids()),
                            Integer.toString(o.getId()));

                    st.executeUpdate(sql);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case "3": // Delete.
                System.out.print("Sur quel train ? (donner l'id) : ");
                while (!(id = scanner.nextLine().trim()).matches("^\\d+$"));

                try (Statement st = conn.createStatement()) {
                    int nb = st.executeUpdate("DELETE FROM train WHERE id = " + id);

                    switch (nb) {
                    case 1: // Success.
                        System.out.println("Suppression réussie");
                        break;
                    case 0: // Id not found.
                        System.out.println("Train non trouvé pour l'id '" + id + "'");
                        break;
                    default: // Many deleted (multiple id => impossible).
                        System.err.println("Oula ! On est mal !!!");
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        } while (!"0".equals(line));

        System.out.println("Merci, et à bientôt !");

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
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
