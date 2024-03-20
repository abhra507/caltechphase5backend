package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
public class ContactController {
	
    @Autowired
    ContactService contactservice;
    
    @ResponseBody
    @RequestMapping("/contact")
    public boolean contactUs(@RequestBody Contact contact, Model model){
        return contactservice.saveMessage(contact);
    }

}
