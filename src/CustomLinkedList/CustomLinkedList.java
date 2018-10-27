/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomLinkedList;

/**
 *
 * @author Mohammed El-Agha
 */
public class CustomLinkedList<E> {
    private Node head;
    private Node tail;
    private int size = 0;
    
    public void addAtHead(E data) {
        if(empty()) {
            head = new Node(data);
            tail = head;
            size = size + 1;
        } else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
            size = size + 1;
        }
    }
    
    public void addAtTail(E data) {
        if(empty()) {
            tail = new Node(data);
            head = tail;
            size = size + 1;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
            size = size + 1;
        }
    }
    
    public void add(E data) {
        if(empty()) {
            addAtHead(data);
        } else {
            addAtTail(data);
        }
        size = size + 1;
    }
    
    public void add(int position, E data) {
        if(position == 0) {
            addAtHead(data);
        } else if(position == size - 1) {
            addAtTail(data);
        } else {
            if(!empty()) {
                int index = 0;
                Node current = head;
                Node previous = null;
                while(index <= position) {
                    if(index - position == -1) {
                        previous = current;
                    }
                    if(index == position) {
                        previous.next = new Node(data);
                        previous.next.next = current;
                    }
                    current = current.next;
                    index = index + 1;
                }
            }
        }
        size = size + 1;
    }
    
    
    public void deleteHead() {
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size = size - 1;
    }
    
    public void deleteTail() {
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            for(int i = 0 ; i < size - 1 ; i++) {
                if(i == size - 2) {
                    tail = current;
                }
                current = current.next;
            }
        }
        size = size - 1;
    }
    
    public void delete(int position) {
        if(position == 0) {
            deleteHead();
        } else if(position == size - 1) {
            deleteTail();
        } else {
            Node current = head;
            for(int i = 0 ; i <= position ; i++) {
                if(i == position - 1) {
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
        size = size - 1;
    }
    
    public boolean empty() {
        if(head == null || tail == null) {
            return true;
        } else 
            return false;
    }
    
    public E getHead() {
        return (E) head.getData();
    }
    
    public E getTail() {
        return (E) tail.getData();
    }
    
    public E get(int position) {
        if(position == 0) {
            return getHead();
        } else if(position == size - 1) {
            return getTail();
        } else {
            Node current = head;
            for(int i = 1 ; i <= position ; i++) {
                current = current.next;
                if(i == position) {
                    break;
                }
            }
            return (E) current.getData();
        }
    }
    
    public int size() {
        return size;
    }
    
    
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList();
        
//        list.addAtHead("Mohammed");
//        list.addAtHead("Ali");
//        list.addAtHead("Ahmed");
//        list.addAtTail("Hosam");
//        list.addAtTail("Hisham");
        
        list.addAtHead("Mohammed");
        list.addAtTail("Hosam");
        list.addAtTail("Ali");
        list.add(1, "Doaa");
        list.add(2, "Soso");
        list.delete(1);
        
        System.out.println(list.get(2));
    }
}
