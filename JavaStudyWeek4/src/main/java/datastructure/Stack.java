package datastructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    int stackData[];
    int topIndex;

    Stack(int size) {
        stackData = new int[size];
        topIndex = -1;
    }
    Stack() {
        stackData = new int[2];
        topIndex = -1;
    }
    int size(){
        return topIndex+1;
    }

    void push(int data) {
        if (size() == stackData.length) {
            resize(stackData.length*2);
        }
        stackData[++topIndex] = data;

    }

    int pop() {
        if (topIndex == -1) {
            throw new EmptyStackException();
        }
        int popValue = stackData[topIndex--];
        if(size()>0 && size()==stackData.length/4){
            resize(stackData.length/2);
        }
       return popValue;
    }

    void resize(int size) {
        int newStackData[] = new int[size];
        for (int i = 0; i < size(); i++) {
            newStackData[i] = stackData[i];
        }
        stackData = newStackData;
    }

    @Override
    public String toString() {
        String toStr="[ ";
        for (int i = 0; i < size() ; i++) {
            toStr += stackData[i]+" ";
        }
        toStr+="]";
        return toStr;
    }
}
