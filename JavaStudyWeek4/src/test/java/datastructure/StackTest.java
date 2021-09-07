package datastructure;

import org.junit.jupiter.api.Test;

class StackTest {
    Stack st = new Stack();
    @Test
    void test(){
        st.push(1);
        System.out.println(st);
        st.push(2);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        st.push(3);
        System.out.println(st);
        st.pop();
        System.out.println(st);
    }

}