package datastructure;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue {
    int queueData[];
    int frontIndex;
    int rearIndex;
    int size;

    Queue() {
        queueData = new int[2];
        frontIndex=rearIndex=this.size=0;

    }
    void add(int data) {
        if (this.size+1 == queueData.length) {
            resize(queueData.length*2);
        }
        rearIndex=(rearIndex+1)%queueData.length;
        queueData[rearIndex] = data;
        this.size++;
    }
    int delete() {
        if (this.size==0) {
        throw new NoSuchElementException();
        }
        frontIndex=(frontIndex+1)%queueData.length;
        int delValue=queueData[frontIndex];
        this.size--;
        if(this.size>0 && this.size==queueData.length/4){
            resize(queueData.length/2);
        }
        return delValue;
    }

    void resize(int size) {
        int newQueueData[] = new int[size];
        for (int i = 1,j=frontIndex+1; i < this.size+1;i++,j++) {
            newQueueData[i] = queueData[j%queueData.length];
        }
        frontIndex = 0;
        rearIndex = this.size;
        queueData = newQueueData;
    }

    @Override
    public String toString() {
        String toStr="[ ";
        for (int i = 1; i < this.size+1; i++) {
            toStr += queueData[(frontIndex+i)% queueData.length]+" ";
        }
        toStr+="]";
        return toStr;
    }
}
