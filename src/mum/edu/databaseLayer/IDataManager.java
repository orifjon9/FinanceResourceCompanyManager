package mum.edu.databaseLayer;

import java.util.List;

/**
 * Created by orifjon9 on 4/17/2017.
 */
public interface IDataManager<T> {
    T getElement(int id);
    List<T> getElements();
    boolean add(T element);
    boolean update(T element);
    boolean delete(T element);
}
