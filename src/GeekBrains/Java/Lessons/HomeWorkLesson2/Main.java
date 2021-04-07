package GeekBrains.Java.Lessons.HomeWorkLesson2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Statement stmt;

    public Main() {
    }

    public static void main(String[] args) {

    }
    // метод создания таблицы
    public static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Table (\n    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n    prodid  TEXT UNIQUE,\n    title TEXT,\n    cost INTEGER\n);");
    }

    // метод для добавления одной записи в таблицу
    public static void insertOneEntry() throws SQLException {
        stmt.executeUpdate("INSERT INTO Table (name, score) VALUES ('Bob4', 100);");
    }

    // метод для получения записи из таблицы
    public static void selectEntry() throws SQLException {
        System.out.println("ищем");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        String sql = String.format("SELECT cost FROM Table where prodid = '%s';", result);
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("cost"));
        }
    }

    // метод удаления одной записи из тблицы
    public static void deleteOneEntry() throws SQLException {
        stmt.executeUpdate("DELETE FROM Table WHERE id = 5;");
    }

    // метод удаление таблицы
    public static void dropTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS Table;");
    }

}
