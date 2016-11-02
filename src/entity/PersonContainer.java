package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonContainer implements Serializable {
    public static final String DB_PATH = "/home/ddexster/IdeaProjects/forum/src/files/users.db";
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());

    public PersonContainer() {
    }

    public static synchronized void writeToFile(PersonContainer container) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DB_PATH)))) {
            stream.writeObject(container);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PersonContainer getContainer() {
        PersonContainer container = null;
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DB_PATH)))) {
            return container = ((PersonContainer) stream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new PersonContainer();
    }

    public boolean checkPass(String login, String pass) {
        if (this.isExist(login)) {
            Person person = this.getPerson(login);
            if (person.getPass().equals(pass)) return true;
        }
        return false;
    }

    public boolean isExist(String login) {
        for (Person person : this.persons) {
            if (person.getNick().equalsIgnoreCase(login)) return true;
        }
        return false;
    }

    public List<Person> add(Person person) {
        this.persons.add(person);
        return this.persons;
    }

    public List<Person> remove(Person person) {
        this.persons.remove(person);
        return this.persons;
    }

    public List<Person> remove(Integer index) {
        this.persons.remove(index);
        return this.persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public PersonContainer setPersons(List<Person> persons) {
        this.persons = persons;
        return this;
    }

    public Person getPerson(String login) {
        for (Person person : persons) {
            if (person.getNick().equalsIgnoreCase(login)) return person;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonContainer{");
        sb.append("persons=").append(persons);
        sb.append('}');
        return sb.toString();
    }
}
