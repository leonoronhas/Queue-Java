package Queues;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {

        // If array is full create new array and double de capacity
        // then copy over the old array to the new one - O(n)
        if (back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        // No resizing needed O(1)
        queue[back] = employee;
        back++;
    }

    public int size() {
        return back - front;
    }

    public Employee remove() {

        // Empty queue?
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        // Always take elements from the front
        Employee employee = queue[front];
        queue[front] = null;
        front++;

        // if now empty, reset queue
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        // Empty queue?
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
