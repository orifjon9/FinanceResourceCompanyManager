package mum.edu.databaseLayer.factory;

import mum.edu.businesslogic.model.Account;
import mum.edu.businesslogic.model.Balance;
import mum.edu.businesslogic.model.Customer;
import mum.edu.businesslogic.model.Transaction;
import mum.edu.databaseLayer.dao.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class DataStoreFactory implements IDataStoreFactory {
    private static IDataStoreFactory instance = new DataStoreFactory();
    private static Map<Object, IDataManager> stores = new HashMap<>();

    static {
        stores.put(Account.class, new AccountManager());
        stores.put(Balance.class, new BalanceManager());
        stores.put(Transaction.class, new TransactionManager());
        stores.put(Customer.class, new CustomerManager());
    }

    private DataStoreFactory(){}

    public static IDataStoreFactory getInstance(){
        return instance;
    }

    @Override
    public IDataManager createManager(Object object) {
        if(stores.containsKey(object))
            return stores.get(object);

        return null;
    }
}
