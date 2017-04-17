package mum.edu.databaseLayer;

import mum.edu.businesslogic.model.Account;
import mum.edu.databaseLayer.command.DataInvoke;
import mum.edu.databaseLayer.command.ICommand;
import mum.edu.databaseLayer.command.StoreCommandFactory;

import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public abstract class IContextLayer<T> {
    private DataInvoke dataInvoke = new DataInvoke();

    public abstract void save(T value);
    public abstract T getElement(int id);
    public abstract List<T> getElements();
    public abstract IDataManager<T> getDataManager();

    public void save(Account value) {
        AbstractElement element = (AbstractElement) value;

        if (element == null) return;
        if (element.getElementState() == ElementState.None) return;

        ICommand command = StoreCommandFactory.getInstance().createCommand(element.getElementState());

        command.setDataManager(getDataManager());
        command.setElement(value);

        dataInvoke.setCommand(command);
        dataInvoke.execute();
    }
}
