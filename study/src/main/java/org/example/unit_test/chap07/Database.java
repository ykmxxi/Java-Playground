package org.example.unit_test.chap07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static final Map<Long, User> users = new HashMap<>();
    private static final List<Company> companies = new ArrayList<>();

    public static Company getCompany(final Long userId) {
        User user = users.get(userId);
        for (Company company : companies) {
            if (company.contains(user)) {
                return company;
            }
        }
        return null;
    }

    public static User getUser(final Long userId) {
        return users.get(userId);
    }

    public static void saveCompany(final Company company) {
        if (companies.contains(company)) {
            companies.remove(company);
        }
        companies.add(company);
    }

    public static void saveUser(final User user) {
        users.put(user.getUserId(), user);
    }

}
