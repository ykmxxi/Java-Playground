package org.example.unit_test.chap05;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<>();

    public CustomerRepository() {
        customers.put(1L, new Customer(1L));
    }

    Customer findById(final Long id) {
        if (customers.containsKey(id)) {
            return customers.get(id);
        }
        return null;
    }

}
