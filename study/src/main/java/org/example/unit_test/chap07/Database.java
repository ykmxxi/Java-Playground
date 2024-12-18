package org.example.unit_test.chap07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.unit_test.chap07.domain.Company;
import org.example.unit_test.chap07.domain.User;

public class Database {

    private static final Map<Long, User> users = new HashMap<>();
    private static final List<Company> companies = new ArrayList<>();

    public Company getCompany(final Long userId) {
        User user = users.get(userId);
        for (Company company : companies) {
            if (company.contains(user)) {
                return company;
            }
        }
        return null;
    }

    public User getUser(final Long userId) {
        return users.get(userId);
    }

    public void saveCompany(final Company company) {
        if (companies.contains(company)) {
            companies.remove(company);
        }
        companies.add(company);
    }

    public void saveUser(final User user) {
        users.computeIfPresent(user.getUserId(), (k, v) -> user);
    }

}
