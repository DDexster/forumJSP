package entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Theme implements Serializable {
    private String name;
    private List<Message> messages = Collections.synchronizedList(new LinkedList<>());

    public Theme() {
    }

    public Theme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Theme setName(String name) {
        this.name = name;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Theme setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public Theme add(Message message) {
        this.messages.add(message);
        return this;
    }


}
