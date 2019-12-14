package Tests.test_day7;

import org.testng.annotations.*;


public class AnnotationTest {
    @BeforeClass
    public void ForOnceBeforeTests(){
        System.out.println("It will work only once BEEFORE the tests");
    }
    @BeforeMethod
    public void setup() {
        System.out.println("Before method!");
    }

    @Test
    public void test1() {
        System.out.println("Test 1" );
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
    }

    @AfterMethod
    public void endOfTest() {
        System.out.println("After test");
    }


    @AfterClass
    public void ForOnceAfterTests(){
        System.out.println("It will work only once AFTER the tests");
    }
}
/*
It will work only once BEEFORE the tests

Before method!

Test 1

After test

Before method!

Test 2

After test

Before method!

Test 3

After test

It will work only once AFTER the tests

===============================================
Default Suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================

*/
