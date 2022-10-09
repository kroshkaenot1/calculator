package com.neoflex.calculator.controllers;

import com.neoflex.calculator.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private CalculateService calculateService;
    @GetMapping("/calculate")
    private String getCalculatorPage(){
        return "calculate";}
    @PostMapping("/calculate")
    private String calculate(@RequestParam(value = "salary") int salary,
                             @RequestParam(value = "days") int days,
                             @RequestParam(value = "date",required = false) String date, Model model){
        String vacPay = calculateService.calculateVacationPay(salary,days,date);
        String message = "Ваша сумма отпускных составит: " + vacPay;
        model.addAttribute("message",message);
        return "calculate";
    }
}
