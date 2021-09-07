package junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JunitClassTest {
    @BeforeAll
    static void beAll(){
        System.out.println("beforeall");
    }

    @DisplayName("DisPlayNameTEST")
    @Test
    void test1(){
        JunitClass junitObject = new JunitClass();
        assertNotNull(junitObject,()->"not be null");
        System.out.println("Not Null");
    }

    @Test
    void test2(){
        //AssertionFailedError
        JunitClass junitObject = new JunitClass(1);
        assertEquals(junitObject.intIv,2,"object intvalue must be 2");
        System.out.println("Equals");
    }

    @Test
    @Disabled
    void disable(){
        System.out.println("disabled");
    }


    @AfterAll
    static void afAll(){
        System.out.println("afterall");
    }



}