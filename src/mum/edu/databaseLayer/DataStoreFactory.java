package mum.edu.databaseLayer;

import mum.edu.businesslogic.model.Account;
import mum.edu.databaseLayer.dao.AccountManager;

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
