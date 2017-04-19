package mum.edu.databaseLayer.dao;
import mum.edu.businesslogic.model.Account;
import mum.edu.databaseLayer.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class AccountManager implements IDataManager<Account>{

    @Override
    public Account getElement(int id) {
        try (ResultSet resultSet = executeQuery("SELECT * FROM account WHERE accountid = " + id)) {

            while (resultSet.next()) {
                return convertToAccount(resultSet);

            }

            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Account> getElements() {
        List<Account> accounts = new ArrayList<>();
        try (ResultSet resultSet = executeQuery("SELECT * FROM account")) {

            while (resultSet.next()) {
                accounts.add(convertToAccount(resultSet));
            }

            return accounts;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Account> getElements(Object obj1, Object obj2) {
        return null;
    }

    @Override
    public boolean add(Account element) {

        try (Connection connection = DBConnection.SQLiteConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO account(number, currency,  startdate, enddate, interestrate, type) VALUES(?,?,?,?,?,?);")) {

            Class.forName("org.sqlite.JDBC");

            setParameters(statement, element);

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

            setParameters(statement, element);
            statement.setInt(7, element.getId());

            return statement.executeUpdate() > 0;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(Account element) {
        return executeUpdate("DELETE FROM account WHERE accountid = " + element.getId()) > 0;
    }

    private void setParameters(PreparedStatement statement, Account account) throws SQLException {
        statement.setInt(1, account.getAccountNumber());
        statement.setString(2, account.getCurrency());
        statement.setString(3, account.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        statement.setString(4, account.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        statement.setFloat(5, account.getInterestRate());
        statement.setString(6, account.getType());
    }

    private Account convertToAccount(ResultSet resultSet) throws SQLException{
        Account account = new Account();

        account.setId(resultSet.getInt("accountid"));
        account.setAccountNumber(resultSet.getInt("number"));
        account.setStartDate(LocalDate.parse(resultSet.getString("startdate")));
        account.setEndDate(LocalDate.parse(resultSet.getString("enddate")));
        account.setInterestRate(resultSet.getFloat("interestrate"));
        account.setType(resultSet.getString("type"));

        return account;
    }
}
