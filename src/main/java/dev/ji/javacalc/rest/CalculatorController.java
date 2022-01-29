package dev.ji.javacalc.rest;

import dev.ji.javacalc.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    private final CalculatorService CalculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.CalculatorService = calculatorService;
    }

    @GetMapping("/greeting")
    public String greet() {
        return "Welcome to our Super Java Calculator";
    }

    @GetMapping
    public String intruct() {
        return "Welcome to our <b>Super Java Calculator</b>. <br> Commands supported as subdirectories: <i>plus, minus, divide, multiply</i>. <br> Syntaxis /Command?num1=(integer)&num2=(integer) <br>  Example http://localhost:8080/calculator/plus?num1=1&num2=2 ";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "+" + num2 + "=" + CalculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "-" + num2 + "=" + CalculatorService.minus(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Error because of dividing by ZERO";
        }
        return num1 + "/" + num2 + "=" + CalculatorService.divide(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "*" + num2 + "=" + CalculatorService.multiply(num1, num2);
    }

}
