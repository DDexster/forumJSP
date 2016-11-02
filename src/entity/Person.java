package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person implements Serializable {
    public static final String DATE_PATTERN = "dd.MM.yyyy";
    private String nick;
    private String pass;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;

    public Person() {
    }

    public Person(String nick, String pass, String name, String surname, String birthDate, String email) {
        this.nick = nick;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(DATE_PATTERN));
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public Person setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Person setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public Person setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(DATE_PATTERN));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getNick() != null ? !getNick().equals(person.getNick()) : person.getNick() != null) return false;
        if (getPass() != null ? !getPass().equals(person.getPass()) : person.getPass() != null) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(person.getSurname()) : person.getSurname() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(person.getBirthDate()) : person.getBirthDate() != null)
            return false;
        return getEmail() != null ? getEmail().equals(person.getEmail()) : person.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getNick() != null ? getNick().hashCode() : 0;
        result = 31 * result + (getPass() != null ? getPass().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("nick='").append(nick).append('\'');
        sb.append(", pass='").append(pass).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
