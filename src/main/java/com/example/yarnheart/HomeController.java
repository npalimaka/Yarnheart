package com.example.yarnheart;

import com.example.yarnheart.model.Subscribers;
import com.example.yarnheart.service.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private SubscriberServiceImpl subscriberService;

    @Autowired
    public HomeController(SubscriberServiceImpl subscriberService) {
        this.subscriberService = subscriberService;
    }

    //HttpSession added as param fixed thymeleaf error//
    //TODO: remove the session after security is done
    @GetMapping("/index")
    public String index(Model model, HttpSession session){
        model.addAttribute("subscribers", new Subscribers());
        return "index";
    }

    @PostMapping("/subscribe")
    public String subscribe(@ModelAttribute Subscribers subscribers){
        subscriberService.save(subscribers);
        return "redirect:/index";
    }
}
