package com.foodparadise;

import com.foodparadise.domain.Food;
import com.foodparadise.order.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/menu", method = RequestMethod.GET)
public class Menu {

    private final FoodRepository foodRepository;

    public Menu(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public String menu(@RequestParam(required = false) String token, Model model) {
        List<Food> foodList = foodRepository.findAll();
        model.addAllAttributes(foodList);
        return "menu";
    }

}
