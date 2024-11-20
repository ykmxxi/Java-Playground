package org.example.unit_test.chap04;

public class HeaderRenderer implements IRenderer {

    @Override
    public String render(final Message message) {
        return "Header: " + message.header() + System.lineSeparator();
    }

}
