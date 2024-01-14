// Linked list

//add, delete, replace, find

import java.util.Objects;

class Node {
    public Integer data;
    public Node next;
    Node trail;
    Node current;

    // Default constructor
    Node() {
        next = null;
    }

    // Default constructor, takes in param which is data to be stored
    Node(Integer x){
        data = x;
        next = null;
    }
    // Pointer to the first element of the list
    Node first = new Node();

    // Insert a node but sorted
    public void insert_sorted(Integer x){

        if(first.next == null){
            Node nn = new Node();
            first.next = nn; // points to the new node
            nn.data = x; // data for this new node is the data
            return;
        }else{
            trail = null;
            current = first.next; // this is a temp
            while(current.data < x && current != null){
                trail = current;
                current = current.next;
            }
        }

        if(trail == null){
            Node nn = new Node();
            nn.next = current;
            first.next = nn;
            nn.data = x;
        }else {
            Node nn = new Node();
            nn.next = trail.next;
            trail.next = nn;
            nn.data = x;
        }
    }

    // class 10/22
    public void insert(Integer x){
        Node nn = new Node(x);
        if(first.next == null){
//            Node nn = new Node(x);
            first.next = nn;
        }else{
            Node temp = first.next;
            Node trail = null;
            while(temp.data < x && temp.next != null){
                trail = temp;
                temp = temp.next;
            }

            if(temp.data >= x){
//                Node nn = new Node(x);
                if(trail == null){
                    nn.next = temp;
                    first.next = nn;
                }else{
                    nn.next = temp;
                    trail.next = nn;
                }
            }else{
//                Node nn = new Node(x);
                temp.next = nn;
            }
        }

    }

    // delete a node
    public int delete(Integer x){
        if(first.next == null){
            return (-1); // Check if it is empty
        } else {
            trail = null;
            current = first.next;
            while(current.data != x && current != null){
                trail = current;
                current = current.next;
            }
            if(trail != null){
                if(current != null){
                    trail.next = current.next;
                    return 1;
                }else {
                    return 0;
                }
            }else { // we found # we want to del in first try
                first.next = current.next;
                return 1;
            }
        }
    }

    public Integer find(Integer x){
        Integer data_to_return;
        if(first.next == null){
            data_to_return = Integer.MIN_VALUE;
        }else{
            Node temp = first.next;
            while(temp != null && !Objects.equals(temp.data, x)){
                temp = temp.next;
            }
            if (temp == null){
                data_to_return = Integer.MIN_VALUE;
            }else {
                data_to_return = temp.data;
            }
        }
        return(data_to_return);
    }

    // if we get the smallest number in the first position, we know it is sorted. try
    // to bubble down to the bottom
    public void sort(Integer x){
        if(first.next == null){ // if there is only one item in the linked list
            return;
        }
        else{
            // we need at least one pointer that will go towards the end
            Node current = first.next; // think of as "outer" loop in
            // bubble sort
            Node index = null;
            while(current != null){
                index = current.next;
                // loop through the linked list while we are not at the end. when at
                // the end,
                // then current will move up. at this point the smallest should be at
                // the bottom
                // Then we start comparing everything in the list to the 2nd position
                // and so on until we reach the end
                while(index != null){
                    if(current.data > index.data){
                        // if what we are at now is bigger than the
                        // next, swap
                        Integer temp = index.data;
                        index.data = current.data;
                        current.data = temp;
                    }
                    // Then advance the index to compare our current to the one after
                    // what we just sorted
                    index = index.next;
                }
                // advance the current pointer after we have compared all  the numbers
                // after
                // current in our linked list. the first position should be the
                // smallest int.
                current = current.next;
            }
        }
    }
}
