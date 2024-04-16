package console.Repository;

import console.Domain.entity;
import console.Exception.ExistingException;
import console.Exception.TwiceException;

import java.util.ArrayList;

public class MemoryRepo<T extends entity> implements IRepo<T>{

    protected ArrayList<T> entitati;

    public MemoryRepo(){
        entitati = new ArrayList<>();
    }

    @Override
    public T getById(int n){
        for(T entitate : entitati){
            if ( entitate.getId() == n) {
                return entitate;
            }
        }
        return null;
    }

    @Override
    public void add(T e) throws TwiceException {
        if(getById(e.getId()) != null)
            throw  new TwiceException("exista deja o entitate adaugata cu id-ul dat\n");
        entitati.add(e);
    }

    public int getPos(T e) {
        for(int i=0;i<size();i++)
            if( entitati.get(i).getId() == e.getId() )
                return i;
        return -1;
    }

    @Override
    public void update(T e) throws ExistingException {
        if(getById(e.getId()) == null)
            throw new ExistingException("entitatea nu exista\n");
        int poz = getPos(e);
        entitati.set(poz,e);
    }

    @Override
    public void delete(int id) throws ExistingException {
        if(getById(id) == null)
            throw new ExistingException("entitatea nu exista\n");
        T e = getById(id);
        int poz = getPos(e);
        entitati.remove(poz);
    }
    public int size(){return entitati.size();}

    public ArrayList<T> getAll(){
        if (entitati.isEmpty()) return null;
        return entitati;
    }

}
