package mum.edu.databaseLayer.dao;

import mum.edu.businesslogic.model.Transaction;
import mum.edu.databaseLayer.AbstractElement;
import mum.edu.databaseLayer.IDataManager;

import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class TransactionManager implements IDataManager<Transaction> {

    @Override
    public Transaction getElement(int id) {
        return null;
    }

    @Override
    public List<Transaction> getElements() {
        return null;
    }

    @Override
    public boolean add(Transaction element) {
        return false;
    }

    @Override
    public boolean update(Transaction element) {
        return false;
    }

    @Override
    public boolean delete(Transaction element) {
        return false;
    }
}
