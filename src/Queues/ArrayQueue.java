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
        // then copy over the old array to the new one - O(n) and unwrap it
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];

            // Unwrap it then copy
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;

            front = 0;
            back = numItems;
        }

        // No resizing needed O(1)
        queue[back] = employee;

        // Wrap it if needed
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public int size() {
        // No wrap occurred
        if (front <= back) {
            return back - front;
        }
        // Wrap occurred
        else {
            return back - front + queue.length;
        }
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
        } else if (front == queue.length) {
            front = 0;
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
        // No wrap occurred
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else{
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
