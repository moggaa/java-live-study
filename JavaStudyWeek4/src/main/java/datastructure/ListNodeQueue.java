package datastructure;

import java.util.NoSuchElementException;

public class ListNodeQueue {
    ListNode front;
    ListNode rear;

    ListNodeQueue() {
        front=null;
        rear=null;
    }
    void add(int data) {
        if(front==null){
            rear = front = new ListNode(data);
        }
        else{
            rear.next = new ListNode(data);
            rear=rear.next;
        }
    }
    int delete() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        int deleteValue = front.value;
        front = front.next;
        return deleteValue;
    }

    @Override
    public String toString() {
        String toStr="[ ";
        ListNode pointerNode = front;
        while(pointerNode!=null){
            toStr+=pointerNode.value+" ";
            pointerNode=pointerNode.next;
        }
        toStr+="]";
        return toStr;
    }
}
