package org.example.unit_test.chap07.application;

import org.example.unit_test.chap07.Database;
import org.example.unit_test.chap07.MessageBus;
import org.example.unit_test.chap07.domain.Company;
import org.example.unit_test.chap07.domain.User;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(final long userId, final String newEmail) {
        User user = database.getUser(userId);
        Company userCompany = database.getCompany(userId);

        int numberOfEmployees = user.changeEmail(userCompany, newEmail);

        database.saveCompany(userCompany);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }

}
