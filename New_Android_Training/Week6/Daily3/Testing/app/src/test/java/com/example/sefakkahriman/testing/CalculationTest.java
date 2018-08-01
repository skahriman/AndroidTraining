package com.example.sefakkahriman.testing;

import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationTest {
// testing class
    int a; int b;

    private Calculation calculation;

    @Mock
    Addition addition;
    @Mock
    Multiplication multiplication;

    @BeforeClass//runs one time
    public static void setUpOnce() {
        System.out.println("setupOnce");
    }

    @Before
    public void setUp() throws Exception {//runs for each method in the class

        System.out.println("CalculationTest.setUp");

//        initialize mocked dependencies
        MockitoAnnotations.initMocks(this);

        //init parameters
        a = 2;
        b = 3;

        calculation = new Calculation(addition, multiplication);
    }

    @After
    public void tearDown() throws Exception {//tuns for each method in the class
        System.out.println("CalculationTest.tearDown");
        calculation = null;
    }

    @Test
    public void add() {
        System.out.println("Add");
        assertEquals(5, calculation.add(2, 3));
    }

    @Test
    public void addTen() {
//        mock the return value of the function
        when(addition.add(a, b)).thenReturn(10);

        assertEquals(20, calculation.addTen(a, b));
    }

    @Test
    public void multiply() {
        when(multiplication.multiply(a, b)).thenReturn(10);
        assertEquals(100, calculation.multiply(a, b));
    }

    @AfterClass
    public static void tearDownOnce() {
        System.out.println("CalculationTest.tearDownOnce");
    }

    public void doSomething() {
        calculation.doSomething();
        verify(multiplication).doSomething();
    }

}