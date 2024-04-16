package console.Service;

import console.Domain.masina;
import console.Exception.ExistingException;
import console.Exception.TwiceException;
import console.Repository.IRepo;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceMasini {

    IRepo<masina> repoMasini;

    public ServiceMasini(IRepo<masina> repoMasini){
        this.repoMasini = repoMasini;
    }

    public void adaugaMasina(int id, String marca, String nume) throws IOException, TwiceException {
        masina m = new masina(id, marca, nume);
        repoMasini.add(m);
    }

    public void modificaMasina(int id, String marca, String nume) throws ExistingException{
        masina m = new masina(id, marca, nume);
        repoMasini.update(m);
    }

    public void stergeMasina(int id) throws Exception {
        repoMasini.delete(id);
    }

    public masina getMasina(int id){
        return repoMasini.getById(id);
    }
    public ArrayList<masina> getMasini(){
        return repoMasini.getAll();
    }

    public int nrMasini(){
        return repoMasini.size();
    }

}
