package mum.edu.databaseLayer.dao;

import mum.edu.businesslogic.model.Customer;
import mum.edu.databaseLayer.AbstractElement;
import mum.edu.databaseLayer.IDataManager;

import java.util.List;


/**
 * Created by orifjon9 on 4/17/2017.
 */
public class CustomerManager implements IDataManager<Customer> {

    @Override
    public Customer getElement(int id) {
        return null;
    }

    @Override
    public List<Customer> getElements() {
        return null;
    }

    @Override
    public boolean add(Customer element) {
        return false;
    }

    @Override
    public boolean update(Customer element) {
        return false;
    }

    @Override
    public boolean delete(Customer element) {
        return false;
    }
}
