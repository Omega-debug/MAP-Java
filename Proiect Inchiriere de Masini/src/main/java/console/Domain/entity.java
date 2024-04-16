package console.Domain;

import java.io.Serializable;

public abstract class entity  implements Serializable {

    private static final long serialVersionUID = 1000L;

    protected final int id;

    public entity(int id){this.id = id ;}

    public int getId(){
        return id;
    }


    public abstract String toStringFile();

}