package usecase;
import entity.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class User implements Serializable {
    private String name;
    private String id;
    private String password;
    private ArrayList<ConcretePokemon> pocket;

    public User(){
        name = "";
        id = "";
        password = "";
        pocket = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }
    public ArrayList<ConcretePokemon> getPocket(){
        return pocket;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String ID){
        this.id = ID;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){return true;}
        if (obj == null){return false;}
        if (getClass() != obj.getClass()){return false;}
        User object = (User) obj;
        return object.getName() == this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, password, pocket);
    }
}
