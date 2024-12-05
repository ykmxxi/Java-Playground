package org.example.unit_test.chap07;

import static org.example.unit_test.chap07.UserType.CUSTOMER;
import static org.example.unit_test.chap07.UserType.EMPLOYEE;

public class User {

    public Long userId;
    public String email;
    public UserType type;

    public void changeEmail(final Long userId, final String newEmail) {
        User user = Database.getUser(userId);
        if (user.email.equals(newEmail)) {
            return;
        }

        Company company = Database.getCompany(userId);
        String companyDomainName = company.getDomainName();

        String[] split = user.email.split("@");
        String emailDomain = split[1];
        UserType userType;
        if (emailDomain.contains(companyDomainName)) {
            userType = EMPLOYEE;
        } else {
            userType = CUSTOMER;
        }
        if (user.type != userType) {
            company.addEmployee(user);
            Database.saveCompany(company);
        }
        user.setEmail(email);
        user.setType(userType);

        Database.saveUser(user);
        MessageBus.sendEmailChangedMessage(user.userId, newEmail);
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
