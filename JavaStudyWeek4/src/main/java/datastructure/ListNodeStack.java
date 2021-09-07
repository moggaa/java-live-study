package datastructure;

import java.util.EmptyStackException;

public class ListNodeStack {
    ListNode top;

    ListNodeStack() {
        top = null;
    }
    void push(int data) {
        if(top==null){
            top= new ListNode(data);
        }
        else{
            ListNode pushNode = new ListNode(data);
            pushNode.next = top;
            top = pushNode;
        }
    }

    int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int popValue = top.value;
        top = top.next;
        return popValue;
    }

    @Override
    public String toString() {
        String toStr="[ ";
        ListNode pointerNode = top;
        while(pointerNode!=null){
            toStr+=pointerNode.value+" ";
            pointerNode=pointerNode.next;
        }
        toStr+="]";
        return toStr;
    }
}


