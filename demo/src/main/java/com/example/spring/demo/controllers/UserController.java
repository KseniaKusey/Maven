package com.example.spring.demo.controllers;
import com.example.spring.demo.model.User;
import com.example.spring.demo.model.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDAO userDAO;
    // private final UserDAO userDAO = new UserDAO();

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        System.out.println("Получение пользователей");
        return "users/show";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        System.out.println("Просмотр всех пользователей");
        model.addAttribute("user", new User());
        return "users/new";
    }
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        System.out.println("Редактирование пользователя с ID = "+ id);
        model.addAttribute("user", userDAO.show(id));
        return "users/edit";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user){
        System.out.println("создаем пользователя " + user.getUsername());
        userDAO.save(user);
        return "redirect:/users";
    }
    @PatchMapping("/{id}")
       public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id){
        System.out.println("обновление пользователя " + user.getUsername());
        userDAO.update(id, user);
        return "redirect:/users";
    }
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") int id){
        System.out.println("Удаляем пользователя с ID = "+ id);
        userDAO.delete(id);
        return "redirect:/users";
    }
}
