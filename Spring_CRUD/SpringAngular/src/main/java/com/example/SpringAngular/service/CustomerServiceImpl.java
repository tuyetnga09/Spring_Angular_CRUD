package com.example.SpringAngular.service;

import com.example.SpringAngular.dto.CustomerCreateDTO;
import com.example.SpringAngular.dto.CustomerDTO;
import com.example.SpringAngular.dto.CustomerUpdateDTO;
import com.example.SpringAngular.entity.Customer;
import com.example.SpringAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerCreateDTO customerCreateDTO) {
        Customer customer = new Customer(
                customerCreateDTO.getCustomername(),
                customerCreateDTO.getCustomeraddress(),
                customerCreateDTO.getMobile()
        );
        customerRepository.save(customer);
        return customer.getCustomername();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomer = customerRepository.findAll();
        List<CustomerDTO> customerDTO = new ArrayList<>();
        for (Customer a : getCustomer) {
            CustomerDTO customerDTO1 = new CustomerDTO(
                    a.getCustomerid(),
                    a.getCustomername(),
                    a.getCustomeraddress(),
                    a.getMobile()
            );
            customerDTO.add(customerDTO1);
        }
        return customerDTO;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepository.existsById(customerUpdateDTO.getCustomerid())) {
            Customer customer = customerRepository.getById(customerUpdateDTO.getCustomerid());
            customer.setCustomername(customerUpdateDTO.getCustomername());
            customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customerRepository.save(customer);

        } else {
            System.out.println("Customer ID do not exit");
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepository.existsById(id))
        {
            customerRepository.deleteById(id);
        }
        else
        {
            System.out.println("Customer id not found");
        }

        return false;
    }
}
