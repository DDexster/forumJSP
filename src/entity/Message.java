package entity;

import java.io.Serializable;

public class Message implements Serializable {
    private Person user;
    private String message;

    public Message(Person user, String message) {
        this.user = user;
        this.message = message;
    }

    public Person getUser() {
        return user;
    }

    public Message setUser(Person user) {
        this.user = user;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUserNick() {
        return user.getNick();
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("user=").append(user);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
