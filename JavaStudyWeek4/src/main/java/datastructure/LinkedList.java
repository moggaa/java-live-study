package datastructure;

import java.util.NoSuchElementException;

public class LinkedList {
    ListNode head;
    int size;
    LinkedList(){
        head = null;
        size = 0;
    }
    ListNode addFront(ListNode nodeToAdd){
        this.head=nodeToAdd;
        size++;
        return nodeToAdd;

    }
    ListNode add(ListNode head, ListNode nodeToAdd, int position){
        if (head==null || position==0){
            throw new NoSuchElementException();
        }
        else{
            ListNode searchNode=search(head,position);
            nodeToAdd.next=searchNode.next;
            searchNode.next=nodeToAdd;
            size++;
        }
        return nodeToAdd;
    }
    ListNode removeFront(){
        ListNode removeNode = this.head;
        this.head=null;
        size--;
        return removeNode;
    }
    ListNode remove(ListNode head, int positionToRemove){
        if (positionToRemove==0){
            throw new NoSuchElementException();
        }
        ListNode searchNode=search(head,positionToRemove);
        ListNode removeNode=searchNode.next;
        searchNode.next=removeNode.next;
        size--;
        return removeNode;
    }
    boolean contains(ListNode head, ListNode nodeTocheck){
        ListNode pointerNode = head;
        while(!pointerNode.equals(nodeTocheck)){
            pointerNode=pointerNode.next;
            if(pointerNode==null){
                return false;
            }
        }
        return true;
    }
    ListNode search(ListNode head, int position){
        ListNode pointerNode = head;
        while (--position>0){
            if (pointerNode==null){
                throw new NoSuchElementException();
            }
            pointerNode=pointerNode.next;
        }
        return pointerNode;
    }

    @Override
    public String toString() {
        String toStr="[ ";
        ListNode pointerNode = head;
        while(pointerNode!=null){
            toStr+=pointerNode.value+" ";
            pointerNode=pointerNode.next;
        }
        toStr+="]";
        return toStr;
    }
}
