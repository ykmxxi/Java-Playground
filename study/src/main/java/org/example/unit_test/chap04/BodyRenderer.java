package org.example.unit_test.chap04;

public class BodyRenderer implements IRenderer {

    @Override
    public String render(final Message message) {
        return "Body: " + message.body() + System.lineSeparator();
    }

}
