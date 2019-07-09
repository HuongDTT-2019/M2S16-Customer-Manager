package com.codegym.Service;

import com.codegym.Model.Customer;
import com.codegym.Persistence.CustomerPersistenceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements GeneralService<Customer> {

    @Autowired
    private CustomerPersistenceImpl customerPersistence;
    @Override
    public List<Customer> findAll() {
        return customerPersistence.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerPersistence.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerPersistence.findById(id);
    }

    @Override
    public Customer findByName(String name) {
        return customerPersistence.findByName(name);
    }

    @Override
    public void update(int id, Customer customer) {
        customerPersistence.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerPersistence.remove(id);
    }

}
