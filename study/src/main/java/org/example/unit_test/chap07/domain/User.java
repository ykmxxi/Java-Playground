package org.example.unit_test.chap07.domain;

import static org.example.unit_test.chap07.domain.UserType.CUSTOMER;
import static org.example.unit_test.chap07.domain.UserType.EMPLOYEE;

public class User {

    public Long userId;
    public String email;
    public UserType type;

    public int changeEmail(final Company company, final String newEmail) {
        if (this.email.equals(newEmail)) {
            return company.getNumberOfEmployees();
        }
        String companyDomainName = company.getDomainName();

        String[] split = this.email.split("@");
        String emailDomain = split[1];
        UserType newType;
        if (emailDomain.contains(companyDomainName)) {
            newType = EMPLOYEE;
        } else {
            newType = CUSTOMER;
        }
        if (this.type != newType) {
            company.addEmployee(this);
        }
        this.setEmail(email);
        this.setType(newType);
        return company.getNumberOfEmployees();
    }

    private void setUserId(final Long userId) {
        this.userId = userId;
    }

    private void setEmail(final String email) {
        this.email = email;
    }

    private void setType(final UserType type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

}
