package com.example.demo.controllers;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.Theatre;
import com.example.demo.model.entity.TheatreOwner;
import com.example.demo.model.entity.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TheatreOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    TheatreOwnerRepository theatreOwnerRepository;
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/owner/create")
    public TheatreOwner createUser(@RequestBody TheatreOwner owner){
        return theatreOwnerRepository.save(owner);
    }
    @PostMapping("/customer/create")
    public  Customer createUser(@RequestBody Customer customer){
      return  customerRepository.save(customer);
    }

}
