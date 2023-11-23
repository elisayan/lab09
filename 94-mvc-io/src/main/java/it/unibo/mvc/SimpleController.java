package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    public static List<String> printHistory;
    
    public SimpleController() {
        printHistory = new LinkedList<>();
    }

    @Override
    public void setNext(String next) {
        if (next == null) {
            throw new IllegalArgumentException("Next string cannot be null");
        } 
        this.nextString = next;
    }

    @Override
    public String getNext() {
        return nextString;
    }

    @Override
    public List<String> getHistory() {
        return new LinkedList<>(printHistory);
    }

    @Override
    public void printString() throws IllegalStateException {
        if (nextString == null) {
            throw new IllegalStateException("Current string is unset");
        }
        System.out.println(nextString);
        printHistory.add(nextString);
    }

}
