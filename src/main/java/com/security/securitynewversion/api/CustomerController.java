package com.security.securitynewversion.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public String createCustomer(){
        return "createCustomer";
    }
    @PutMapping
    public String updateCustomer(){
        return "updateCustomer";
    }

    @DeleteMapping
    public String deleteCustomer(){
        return "deleteCustomer";
    }

    @GetMapping
    public String findCustomer(){
        return "findCustomer";
    }

    @GetMapping( "list")
    public String findAllCustomer(){
        return "findAllCustomer";
    }

}
