package junit;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is method @BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is method @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    This is method @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    This is method @AfterEach");
    }


    @Test
    void firstTest() {
        System.out.println("            It's a first test");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            It's a second test");
        Assertions.assertTrue(3 > 2);
    }

}