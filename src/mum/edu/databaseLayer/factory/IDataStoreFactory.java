package mum.edu.databaseLayer.factory;

import mum.edu.databaseLayer.dao.IDataManager;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public interface IDataStoreFactory {
    IDataManager createManager(Object object);
}
