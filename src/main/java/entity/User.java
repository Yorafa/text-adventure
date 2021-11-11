package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class User implements Serializable {
    private String name;
    private int id;
    private String password;
    private ArrayList<Pokemon> pocket;

    public User() {
        this.name = "";
        this.id = 0;
        this.password = "";
        this.pocket = new ArrayList<>();
    }

    public User(String name, String password) {
        this.name = name;
        this.id = 0;
        this.password = password;
        this.pocket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Pokemon> getPocket() {
        return pocket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User object = (User) obj;
        return this.getName().equals(object.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, password, pocket);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", pocket=" + pocket +
                '}';
    }
}