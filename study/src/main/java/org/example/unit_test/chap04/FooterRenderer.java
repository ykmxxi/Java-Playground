package org.example.unit_test.chap04;

public class FooterRenderer implements IRenderer {

    @Override
    public String render(final Message message) {
        return "Footer: " + message.footer() + System.lineSeparator();
    }

}
