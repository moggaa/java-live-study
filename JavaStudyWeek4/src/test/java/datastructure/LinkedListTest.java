package datastructure;

import org.junit.jupiter.api.Test;

class LinkedListTest {
    LinkedList li= new LinkedList();
    @Test
    void test(){
        System.out.println("hi");
        System.out.println(li);
        li.addFront(new ListNode(0));
        System.out.println(li);
        li.add(li.head,new ListNode(1),1);
        System.out.println(li);
        li.add(li.head,new ListNode(2),2);
        System.out.println(li);
        li.remove(li.head,1);
        System.out.println(li);
        System.out.println(li.contains(li.head,new ListNode(1)));
        System.out.println(li.contains(li.head,new ListNode(2)));
        li.removeFront();
        System.out.println(li);


    }

}