package com.example.spring.demo.model.dao;
import com.example.spring.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAO {
    private static int users_count;
    private List<User> users;

    public UserDAO() {
        String[] names = {"Ksenia", "Sonia", "Alex", "Kesha", "Tom"};
        String[] pass = {"123", "456", "Apple", "Gold", "098"};
        Integer[] ages = {20, 30, 46, 18, 55};

        users = new ArrayList<>();
        for (int user_count = 0; user_count < 5; user_count++) {
            users.add(new User(users_count + 1, names[user_count], pass[user_count], ages[user_count]));
            users_count++;
        }
    }

    public static int getUsers_count() {
        return users_count;
    }

    public static void setUsers_count(int users_count) {
        UserDAO.users_count = users_count;
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void update(int id, User user ) {
        User tmp = show(id);
        tmp.setUsername(user.getUsername());
        tmp.setPassword(user.getPassword());
        tmp.setAge(user.getAge());
        System.out.println(tmp);
    }

    public void save(User user) {
        user.setId(++users_count);
        users.add(user);
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);

    }
}
