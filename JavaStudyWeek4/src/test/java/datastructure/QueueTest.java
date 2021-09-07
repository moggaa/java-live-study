package datastructure;

import org.junit.jupiter.api.Test;

class QueueTest {
    Queue qu = new Queue();
    @Test
    void test(){
        System.out.println(qu);

        qu.add(1);
        System.out.println(qu);

        qu.add(2);
        System.out.println(qu);

        qu.add(3);
        System.out.println(qu);

        qu.add(4);
        System.out.println(qu);

        qu.delete();
        qu.delete();
        qu.delete();
        System.out.println(qu);
        qu.delete();
        System.out.println(qu);
        //qu.delete();
        //System.out.println(Arrays.toString(qu.queueData));
    }

}