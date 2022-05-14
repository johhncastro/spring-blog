package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiceController {


    @GetMapping("/roll-dice")
    public String diceStart(){
        return "roll-dice/roll-dice";
    }



    @GetMapping("/roll-dice/{number}")
    public String diceRolled(@PathVariable int number, Model model){

        int randomNum = (int)Math.floor(Math.random()*(6-1+1)+1);

        String message = "";

        if(randomNum == number){
            message = "You guessed correctly!";
        } else {
            message = "you got it wrong";
        }

        System.out.println("What did we get? Randomnum = " + randomNum + "; userNumber = " + number);

        System.out.println("message = " + message);


        model.addAttribute("number", number);
        model.addAttribute("message", message);
        model.addAttribute("randomNum", randomNum);
        return "roll-dice/roll-dice";
    }


}
