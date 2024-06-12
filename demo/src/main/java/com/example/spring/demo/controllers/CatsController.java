package com.example.spring.demo.controllers;

import com.example.spring.demo.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CatsController {
    @Autowired
    @Qualifier("First Cat")private Cat first_cat;
    @Autowired
    @Qualifier("Second Cat")private Cat second_cat;
    @Autowired
    @Qualifier("Third Cat")private Cat third_cat;

    @GetMapping("/cats")
    public String cats(Model model) {
        /*ArrayList<Cat> catsList = new ArrayList<>();
        catsList.add(first_cat);
        catsList.add(second_cat);
        catsList.add(third_cat);
        model.addAttribute("cats", catsList);
        /*System.out.println(second_cat.getName());
        model2.addAttribute("second_cat", second_cat);
        System.out.println(third_cat.getName());
        model3.addAttribute("third_cat", third_cat);*/
        return "cats";
    }
    @GetMapping("/cats/first_cat")
    public String first_cat(Model model) {
        ArrayList<Cat> firstCatList = new ArrayList<>();
        firstCatList.add(first_cat);
        model.addAttribute("first_cat",firstCatList);
        return "first_cat";
    }
    @GetMapping("/cats/second_cat")
    public String second_cat(Model model) {
        ArrayList<Cat> secondCatList = new ArrayList<>();
        secondCatList.add(second_cat);
        model.addAttribute("second_cat",secondCatList);
        return "second_cat";
    }
    @GetMapping("/cats/third_cat")
    public String third_cat(Model model) {
        ArrayList<Cat> thirdCatList = new ArrayList<>();
        thirdCatList.add(third_cat);
        model.addAttribute("third_cat",thirdCatList);
        return "third_cat";
    }

    @GetMapping("/cats/testParams")
    public String testParams(@RequestParam("name") String name,
                             @RequestParam("breed") String breed,
                             @RequestParam("description") String description, Model model){
        model.addAttribute("params1", name);
        model.addAttribute("params2", breed);
        model.addAttribute("params3", description);
        return "answer_params";
    }

}

