package com.example.SpringAngular.service;

import com.example.SpringAngular.dto.CustomerCreateDTO;
import com.example.SpringAngular.dto.CustomerDTO;
import com.example.SpringAngular.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerCreateDTO customerCreateDTO);

    List<CustomerDTO> getAllCustomer();

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);
}
