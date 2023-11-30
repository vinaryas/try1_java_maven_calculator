package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String calculatorForm() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation,
            Model model) {

        double result;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = (num2 != 0) ? num1 / num2 : Double.POSITIVE_INFINITY;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        model.addAttribute("result", result);
        return "calculator";
    }
}
