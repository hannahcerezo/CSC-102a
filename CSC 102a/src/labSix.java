/*
Hannah Cerezo
CSC 102 Lab 6: Linked Lists
11/11/21
 */

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Iterator;
import java.util.Scanner;

class LinkedList implements Iterable<Integer>{

    private Iterator iterator;

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterable(this);
    }

    static class node {
        public Integer data;
        public node next;

        node(){
            next = null;
        }
        node(Integer x){
            data = x;
            next = null;
        }
    }

    node first = new node(); // Create instance of first node

    // implement these methods: addFirst, getFirst, removeFirst
    // AddFirst
    public boolean addFirst(Integer x){

        if(first.next == null){
            // empty list
            first.next = new node(x);
            return true;
        }else{
            node new_node = new node(x);
            // new node points to the first item.
            new_node.next = first.next;
            first.next = new_node;
        }
        return true;
    }

    // Insert a node in the correct place (sorted)
    public void insert(Integer x){
        node newNode = new node(x);
        if(first.next == null){
            // empty list
            first.next = new node(x);
        }else {
            node temp = first.next;
            node trail = null;
            while(temp.data < x && temp.next != null){
                trail = temp;
                temp = temp.next;
            }

            if(temp.data >= x){
                if(trail == null){
                    newNode.next = temp;
                    first.next = newNode;
                }else{
                    newNode.next = temp;
                    trail.next = newNode;
                }
            }else{
                temp.next = newNode;
            }
        }
    }

    // Get the first node of the linked list
    public Integer getFirst() {
        Integer return_this_data;
        if(first.next == null){
            return_this_data = Integer.MIN_VALUE;
        }else{
            node temp = first.next;
            return_this_data = temp.data;
        }
        return (return_this_data);
    }

    // Remove a node
    public boolean removeNode(Integer x) {
        if(first.next == null) {
            return false;
        } else {
            node temp = first.next;
            node trail = null;
            while (temp.next != null && !Objects.equals(temp.data, x)) {
                trail = temp;
                temp = temp.next;
            }
            if (trail == null) {
                removeFirst();
                return true;
            }
            // delete last?
            trail.next = temp.next;
            return true;
        }
    }

    // removeFirst
    public Integer removeFirst() {
        Integer return_this_data;
        if (first.next == null) {
            return_this_data = Integer.MIN_VALUE;
        } else {
            node temp = first.next;
            return_this_data = temp.data;
            first.next = temp.next;
        }
        return (return_this_data);
    }
}

// inner class that functions as an iterator interface for LL class
class LinkedListIterable implements Iterator{

    private LinkedList.node nodePtr;
    LinkedListIterable(LinkedList aThis){
        nodePtr = aThis.first.next;
    }

    @Override
    public boolean hasNext() {
        return nodePtr != null;
    }

    @Override
    public Object next() {
        if (nodePtr == null){
            throw new NoSuchElementException("No more elements");
        }
        Integer temp = nodePtr.data;
        nodePtr = nodePtr.next;
        return temp;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}

public class labSix {

    public static void main(String[] args){
        // Instantiate a new linked list and add some elements to it
        LinkedList lList = new LinkedList();
        lList.addFirst(9);
        lList.insert(10);
        lList.insert(15);
        lList.insert(24);
        lList.insert(32);
        lList.insert(45);

        // Iterate through the linked list and display the methods that it has
        System.out.println("Iterate through the Linked List: \n");
        Iterator<Integer> iter = lList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // getFirst, addFirst, removeFirst
        int first_element = lList.getFirst();
        System.out.println("First element: " + first_element);
        int remove_first = lList.removeFirst();
        System.out.println("Remove the first: " + remove_first);
        lList.addFirst(90);
        System.out.println("Add 90 as the first item.");
        for(Integer item: lList){
            System.out.println(item);
        }
        System.out.println("Remove 32");
        lList.removeNode(32);
        System.out.println("Insert 75");
        lList.insert(75);
        for(Integer item: lList){
            System.out.println(item);
        }
        iter.remove();

        // Instantiate a new linked list. have a user enter some numbers and add them
        // to the new linked list
        LinkedList users_ll = new LinkedList();
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter some numbers or 'x' to exit: ");

        // Add each number they enter to a linked list. When they enter
        // "x", stop asking. iterate through the new linked list, add the numbers
        // together (probably will need some temp) and print the sum.

        boolean enter_num = true;
        // while loop to continue asking user for numbers
        while (enter_num) {
            String input;
            input = kb.nextLine();
            if (input.equals("x")) {
                enter_num = false;
            }else{
                // parse the string into an Integer
                Integer num = Integer.parseInt(input);
                // add it to the linked list
                users_ll.insert(num);
            }
        }
        // Iterate through the linked list. add the numbers together
        Iterator<Integer> myIter = users_ll.iterator();
        System.out.println("Linked List sum: ");
        int temp = 0;
        // Sum the numbers in the linked list
        while(myIter.hasNext()){
            temp = temp + myIter.next();
        }
        System.out.println(temp);
    }

}