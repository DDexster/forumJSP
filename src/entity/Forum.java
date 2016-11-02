package entity;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Forum implements Serializable {
    public static final String FORUM_DB = "/home/ddexster/IdeaProjects/forum/src/files/forum.db";
    private List<Theme> themes = Collections.synchronizedList(new LinkedList<>());

    public Forum() {
    }

    public static synchronized void writeToFile(Forum forum) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FORUM_DB)))) {
            stream.writeObject(forum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Forum getForum() {
        Forum forum = null;
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FORUM_DB)))) {
            forum = (Forum) stream.readObject();
            return forum;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Forum();
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public Forum setThemes(List<Theme> themes) {
        this.themes = themes;
        return this;
    }

    public Forum addTheme(String name) {
        this.themes.add(new Theme(name));
        return this;
    }

    public Forum addTheme(Theme theme) {
        this.themes.add(theme);
        return this;
    }

    public Theme getTheme(String name) {
        for (Theme theme : themes) {
            if (theme.getName().equals(name)) return theme;
        }
        return null;
    }

    public Forum setTheme(Theme theme) {
        for (int i = 0; i < this.themes.size(); i++) {
            if (this.themes.get(i).getName().equals(theme.getName())) this.themes.set(i, theme);
        }
        return this;
    }
}
