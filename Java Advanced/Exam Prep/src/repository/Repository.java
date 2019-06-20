package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int idCounter = -1;

    public Repository() {
        this.data = new LinkedHashMap<>();
    }
    public void add(Person person){
         idCounter++;
        if(!data.containsKey(this.idCounter)){
            data.put(this.idCounter,person);
        }
    }
    public Person get(int id){
        return data.get(id);
    }
    public boolean update(int id, Person newPerson){
        boolean update = false;
        if(data.containsKey(id)){
            update=true;
            data.put(id,newPerson);
        }
        return update;
    }
    public boolean delete(int id){
        boolean delete =false;
        if(data.containsKey(id)){
            data.remove(id);
            delete = true;
        }
        return delete;
    }
    public int getCount(){
        return data.size();
    }
}
