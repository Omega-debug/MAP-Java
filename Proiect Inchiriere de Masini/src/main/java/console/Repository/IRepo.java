package console.Repository;

import console.Domain.entity;
import console.Exception.ExistingException;
import console.Exception.TwiceException;

import java.util.ArrayList;

public interface IRepo<T extends entity> {

    void add(T e)throws TwiceException;
    void update(T e) throws ExistingException;
    void delete(int id) throws ExistingException;
    T getById(int id);
    int size();
    ArrayList<T> getAll();

}