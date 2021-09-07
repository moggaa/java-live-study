package datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {
    ListNodeStack st = new ListNodeStack();

    @Test
    void test(){
        System.out.println(st);
        st.push(1);
        System.out.println(st);
        st.push(2);
        st.push(3);
        System.out.println(st);
        assertEquals(st.pop(),3);
        System.out.println(st);
    }

}