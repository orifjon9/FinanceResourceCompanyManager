package mum.edu.databaseLayer;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public interface IDataStoreFactory {
    IDataManager createManager(Object object);
}
