package system;

public abstract class Person {
    protected long id;
    protected String name;
    public Person(){

    }
    public Person(long id,String name){
        this.id = id;
        this.name = name;
    }
}
