package com.example.calculator.controller;

import com.example.calculator.model.CalculationRecord;
import com.example.calculator.repository.CalculationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculationRecordRepository repository;

    @GetMapping("/calculate")
    public CalculationRecord calculate(
            @RequestParam double operand1,
            @RequestParam double operand2,
            @RequestParam String operator) {

        double result;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

        // Create and save the record
        CalculationRecord record = new CalculationRecord();
        record.setOperand1(operand1);
        record.setOperand2(operand2);
        record.setOperator(operator);
        record.setResult(result);

        return repository.save(record);
    }
}
