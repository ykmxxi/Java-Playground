package org.example.chap9.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

    private final Deque<String> pageHistories = new ArrayDeque<>();

    public void visitPage(final String visitUrl) {
        System.out.println("방문: " + visitUrl);
        pageHistories.push(visitUrl);
    }

    public String goBack() {
        pageHistories.pop();
        System.out.println("뒤로 가기: " + pageHistories.peek());
        return pageHistories.peek();
    }
    
}
