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
public class Node<E> {
    public E data;
    public Node next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
