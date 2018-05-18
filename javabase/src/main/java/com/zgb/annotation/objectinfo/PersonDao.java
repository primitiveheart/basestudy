package com.zgb.annotation.objectinfo;

/**
 * Created by admin on 2018/5/17.
 */
public class PersonDao {
    private Person person;

    public Person getPerson() {
        return person;
    }
    @InjectPerson(username = "ztest", age = 12)
    public void setPerson(Person person) {
        this.person = person;
    }
}
