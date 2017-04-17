package mum.edu.databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class DBConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:D:\\MUM\\github\\FinanceResourceCompanyManager\\src\\CreditCard.sqlite";
    private static Connection instance;
    private DBConnection(){}

    public static Connection SQLiteConnection() throws SQLException {
        //if(instance == null) {
            return DriverManager.getConnection(CONNECTION_STRING);
       /* }

        return instance;*/
    }
}
