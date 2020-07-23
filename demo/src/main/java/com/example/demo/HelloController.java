package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String returnPi() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String returnOperation(
            @RequestParam("operation") String operator,
            @RequestParam("x") int x,
            @RequestParam("y") int y) {
        switch(operator) {
            case "add":
                return x + " + " + y + " = " + (x + y);
            case "subtract":
                return x + " - " + y + " = " + (x - y);
            case "multiply":
                return x + " * " + y + " = " + (x * y);
            case "divide":
                if (y != 0) {
                    return x + " / " + y + " = " + (x / y);
                } else {
                    return "Error";
                }
            default:
                return "Enter a valid operation type";
        }
    }

    @PostMapping("/math/sum")
    public String sumDisplay(@RequestParam Map<String,String> keys) {
        String resultString = "";
        int sum = 0;
        for (String i : keys.keySet()) {
            sum += Integer.parseInt(keys.get(i));
            if (resultString == "") {
                resultString = keys.get(i);
            } else {
                resultString += " + " + keys.get(i);
            }
        }
        return resultString + " = " + Integer.toString(sum);
    }

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String mathVolume(
            @PathVariable("l") String length,
            @PathVariable("w") String width,
            @PathVariable("h") String height
    ) {
        int volume = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height);
        return "The volume of a " + length + "x" + width + "x" + height + " rectangle is " + Integer.toString(volume);
    }

    @PostMapping("/math/area")
    public String calculateArea(@RequestParam Map <String, String> map) {
        if (map.containsKey("type")) {
            if (map.get("type").equalsIgnoreCase("circle")) {
                double radius = Double.parseDouble(map.get("radius"));
                if (map.containsKey("radius")) {
                    double area = Double.parseDouble(returnPi()) * (radius * radius);
                    return "The area of a circle with a radius of " + map.get("radius") + " is " +
                            Double.toString(area);
                } else {
                    return "Invalid";
                }
            }
            else if (map.get("type").equalsIgnoreCase("rectangle")) {
                int length;
                int width;
                if (map.containsKey("length")) {
                    length = Integer.parseInt(map.get("length"));
                } else {
                    return "Invalid";
                }
                if (map.containsKey("width")) {
                    width = Integer.parseInt(map.get("width"));
                } else {
                    return "Invalid";
                }

                int area = length * width;
                return "The area of a " + Integer.toString(length) + "x" + Integer.toString(width) +
                        " rectangle is " + Integer.toString(area);
            } else {
                return "Invalid";
            }
        }
        return "Invalid";
    }
}