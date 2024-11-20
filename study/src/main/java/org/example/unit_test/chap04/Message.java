package org.example.unit_test.chap04;

public class Message {

    private String header;
    private String body;
    private String footer;

    public Message(final String header, final String body, final String footer) {
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public String header() {
        return header;
    }

    public String body() {
        return body;
    }

    public String footer() {
        return footer;
    }

}
