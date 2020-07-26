package Lesson2;
import java.sql.*;

public class DataBases {
    private static Connection connection;
    private static Statement stmt;
    static final String driver = "org.sqlite.JDBC";
    static final String base = "jdbc:sqlite:main.db";

    public static void main(String[] args) {
        String tableName = "users";
        String[] columnsForSelect = {"id", "name", "score"};

        try {
            connect(driver, base);
            //create(tableName);
            //insert(tableName, "Alice", 20);
            //select(tableName, columnsForSelect);
            //update(tableName, "Bob", 3);
            //delete(tableName, 4);
            //deleteTable(tableName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect(String _driver, String _base) throws ClassNotFoundException, SQLException {
        Class.forName(_driver);
        connection = DriverManager.getConnection(_base);
        stmt = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int create(String _tableName) throws SQLException {
        String createQuery = "CREATE TABLE " + _tableName + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score INTEGER)";
        int res = stmt.executeUpdate(createQuery);
        return res;
    }

    public static int update(String _tableName, String _field1, int _id) throws SQLException {
        String updateQuery = "UPDATE " + _tableName +
                " SET name = '" + _field1 + "'" +
                "WHERE id = " + _id;
        int res = stmt.executeUpdate(updateQuery);
        return res;
    }

    public static int delete(String _tableName, int _id) throws SQLException {
        String deleteQuery = "DELETE FROM " + _tableName +
                " WHERE id = " + _id;
        int res = stmt.executeUpdate(deleteQuery);
        return res;
    }

    public static int insert(String _tableName, String _name, int _score) throws SQLException{
        String insertQuery = "INSERT INTO " + _tableName + "(name, score) " +
                "VALUES ('" + _name +"', "+ _score +")";
        int res = stmt.executeUpdate(insertQuery);
        return res;
    }

    public static ResultSet select(String _tableName, String... columns) throws SQLException{
        String selectQuery = "SELECT ";
        selectQuery += columns[0];
        for (int i = 1; i < columns.length; i++) {
            selectQuery += ", ";
            selectQuery += columns[i];
        }
        selectQuery += " FROM " + _tableName;
        ResultSet res = stmt.executeQuery(selectQuery);
        return res;
    }

    public static int deleteTable(String _tableName) throws SQLException {
        String deleteQuery = "DROP TABLE " + _tableName;
        int res = stmt.executeUpdate(deleteQuery);
        return res;
    }
}