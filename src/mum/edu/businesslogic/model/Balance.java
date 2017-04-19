package mum.edu.businesslogic.model;

import mum.edu.databaseLayer.AbstractElement;

import java.math.BigDecimal;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class Balance extends AbstractElement {
    private int id;
    private int accountNumber;
    private String balanceCode;
    private BigDecimal balance;

    public Balance(int accountNumber, String balanceCode, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balanceCode = balanceCode;
        this.balance = balance;
    }

    public Balance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
