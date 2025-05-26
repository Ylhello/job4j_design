package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
     public int hashCode() {
         return Objects.hash(name, children);
     }

    @Override
    public String toString() {
        return "User{name='" + name + "', children=" + children + "}";
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Marina", 2);
        User user2 = new User("Marina", 2);

        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(map);
    }
}
