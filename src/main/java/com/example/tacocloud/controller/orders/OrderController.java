package com.example.tacocloud.controller.orders;

import com.example.tacocloud.domain.TacoOrder;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Autowired
    public IngredientRepository ingredientRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute TacoOrder order , Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
       orderRepository.save(order);
        //by calling setComplete() method we are ensuring that the session is cleaned up and
        // ready for a new order the next time user creates a taco.
        sessionStatus.setComplete();
        log.info("Processing order : {}", order);

        return "redirect:/";
    }
}
