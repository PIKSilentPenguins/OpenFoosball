package com.silentpenguins.OpenFoosball.controller;


import com.silentpenguins.OpenFoosball.dao.PersonDao;
import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/")
    public String showHome() {
        List<Person> people = (List<Person>) personDao.findAll();
        for(Person p : people)
            System.out.println(p.toString());

        homeService.initDataBase();

        return "home";
    }

    /*		String result = "";

		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}

		return result;*/
}
