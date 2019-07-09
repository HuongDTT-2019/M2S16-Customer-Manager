package com.codegym.Persistence;

import com.codegym.Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerPersistenceImpl implements GeneralPersistence<Customer> {

    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn","ha noi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn","hcm"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public Customer findByName(String name) {
        List<Customer> list = new ArrayList<>(customers.values());
        List<Customer> listResult = new ArrayList<>();
        for (Customer customer: list){
            if (customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

}
