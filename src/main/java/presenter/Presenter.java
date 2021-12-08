package presenter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Presenter {
    protected Queue<String> messageQueue;

    /**
     * Construct Presenter by empty messageQueue
     */
    public Presenter() {
        this.messageQueue = new ArrayDeque<>();
    }

    /**
     * add a message into messageQueue
     * @param s the sentence information
     */
    public void addToQueue(String s) {
        messageQueue.add(s);
    }

    /**
     * add a list of message into messageQueue
     * @param strings the list of message
     */
    public void addToQueue(List<String> strings) {
        messageQueue.addAll(strings);
    }

    /**
     * show the first message of messageQueue on shell
     */
    public void print() {
        System.out.println(messageQueue.poll());
    }

    /**
     * show all message of messageQueue
     */
    public void printAll() {
        while (!messageQueue.isEmpty()) {
            print();
        }
    }

    /**
     * show the oreder of message
     */
    public void printAllEnum() {
        int i = 1;
        while (!messageQueue.isEmpty()) {
            System.out.print(i + ". ");
            print();
            i += 1;
        }
    }

    /**
     * show the invalid input
     */
    public void notValid() {
        System.out.println("This is not a valid input.");
    }
}