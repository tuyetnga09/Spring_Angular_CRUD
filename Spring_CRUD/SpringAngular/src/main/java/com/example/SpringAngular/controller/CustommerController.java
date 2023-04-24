package com.example.SpringAngular.controller;

import com.example.SpringAngular.dto.CustomerCreateDTO;
import com.example.SpringAngular.dto.CustomerDTO;
import com.example.SpringAngular.dto.CustomerUpdateDTO;
import com.example.SpringAngular.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustommerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/create")
    public String createCustomer(@RequestBody CustomerCreateDTO customerCreateDTO){
        String id = customerService.addCustomer(customerCreateDTO);
        return id;
    }
    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer()
    {
       List<CustomerDTO> customers = customerService.getAllCustomer();
       return customers;
    }
    @PostMapping(path = "/updateCustomer")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String id = customerService.updateCustomer(customerUpdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
       boolean deleteCustomer = customerService.deleteCustomer(id);
       return "deleted";
    }

}
