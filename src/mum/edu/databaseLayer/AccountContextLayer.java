package mum.edu.databaseLayer;

import mum.edu.businesslogic.model.Account;
import mum.edu.databaseLayer.command.DataInvoke;
import mum.edu.databaseLayer.command.ICommand;
import mum.edu.databaseLayer.command.StoreCommandFactory;

import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public class AccountContextLayer extends IContextLayer<Account> {

    private static IContextLayer instance = new AccountContextLayer();
    private IDataManager<Account> dataManager = null;

    private AccountContextLayer(){}

    public static IContextLayer Accounts(){
        return instance;
    }

    @Override
    public Account getElement(int id) {
        return getDataManager().getElement(id);
    }

    @Override
    public List<Account> getElements() {
        return getDataManager().getElements();
    }

    @Override
    public IDataManager<Account> getDataManager() {
        if (dataManager == null) {
            dataManager = DataStoreFactory.getInstance().createManager(Account.class);
        }

        return dataManager;
    }
}
