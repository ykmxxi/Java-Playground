package org.example.unit_test.chap07;

import java.util.List;
import java.util.Objects;

public class Company {

    public String domainName;
    public List<User> employees;

    public boolean contains(final User user) {
        return employees.contains(user);
    }

    public void addEmployee(final User user) {
        employees.add(user);
    }

    public String getDomainName() {
        return domainName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company company)) {
            return false;
        }
        return Objects.equals(domainName, company.domainName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(domainName);
    }

}
