package mum.edu.databaseLayer.dao;

import mum.edu.businesslogic.model.Account;
import mum.edu.databaseLayer.DBConnection;
import mum.edu.databaseLayer.IDataManager;

import java.sql.*;
import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class AccountManager implements IDataManager<Account>{

    @Override
    public Account getElement(int id) {
        try (Connection connection = DBConnection.SQLiteConnection();
             Statement statement = connection.createStatement()) {

            Class.forName("org.sqlite.JDBC");


            ResultSet resultSet = statement.executeQuery("SELECT * FROM account WHERE accountid = " + id);

            Account account = new Account();
            while (resultSet.next()) {


                account.setId(resultSet.getInt("accountid"));
                account.setAccountNumber(resultSet.getInt("number"));
                account.setStartDate(LocalDate.parse(resultSet.getString("startdate")));
                account.setEndDate(LocalDate.parse(resultSet.getString("enddate")));
                account.setInterestRate(resultSet.getFloat("interestrate"));
                account.setType(resultSet.getString("type"));

                break;
            }

            return account;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Account> getElements() {
        return null;
    }

    @Override
    public boolean add(Account element) {

        try (Connection connection = DBConnection.SQLiteConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO account(number, currency,  startdate, enddate, interestrate, type) VALUES(?,?,?,?,?,?);")) {

            Class.forName("org.sqlite.JDBC");
           // statement.setInt(1, element.getId());
            statement.setInt(1, element.getAccountNumber());
            statement.setString(2, element.getCurrency());
            statement.setString(3, element.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setString(4, element.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setFloat(5, element.getInterestRate());
            statement.setString(6, element.getType());

            return statement.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean update(Account element) {

        try (Connection connection = DBConnection.SQLiteConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE account SET number = ?, currency = ?,  startdate = ?, enddate = ?, interestrate = ?, type = ? WHERE accountid = ?;")) {

            Class.forName("org.sqlite.JDBC");

            statement.setInt(1, element.getAccountNumber());
            statement.setString(2, element.getCurrency());
            statement.setString(3, element.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setString(4, element.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            statement.setFloat(5, element.getInterestRate());
            statement.setString(6, element.getType());
            statement.setInt(7, element.getId());

            return statement.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(Account element) {
        try (Connection connection = DBConnection.SQLiteConnection();
             Statement statement = connection.createStatement()) {

            Class.forName("org.sqlite.JDBC");

            return statement.executeUpdate("DELETE FROM account WHERE accountid = " + element.getId()) > 0;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
