package Queues;

public class MyArrayQueue {
    public static void main(String[] args) {

        // Queue implementation with an array - Best case is O(1) if no resize is needed
        // add and remove items are O(1), if resize is needed then O(n)

        ArrayQueue queue = new ArrayQueue(4);

        queue.add(new Employee("Jane", "Jones", 122));
        queue.add(new Employee("Doug", "Jhonson", 288));
        queue.add(new Employee("Leo", "Noronha Santos", 2553));

        queue.printQueue();

        System.out.println("First item is: " + queue.peek());

        queue.remove();

        queue.printQueue();
    }
}
