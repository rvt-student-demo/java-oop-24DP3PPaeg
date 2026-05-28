package rvt;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ToDoDB {
    private static final String DB_URL = "jdbc:sqlite:data/todo.db";

    public ToDoDB(){
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo( id INTEGER PRIMARY KEY, task TEXT NOT NULL) STRICT";
        try(
            Connection conn = connect();
            Statement stmt = conn.createStatement()
        ){
            stmt.execute(sql);
        } catch(SQLException e){
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
}
