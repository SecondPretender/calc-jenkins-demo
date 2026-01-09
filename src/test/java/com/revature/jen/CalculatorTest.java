package com.revature.jen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calc;

    @BeforeAll
    static void initAll(){

    }

    @AfterAll
    static void tearDownAll(){

    }

    @BeforeEach
    public void initOne(){
        calc = new Calculator();
    }

    @AfterEach
    public void afterOne(){
        calc=null;
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "-1, -1, -2",
            "0,0,0",
            "7,3,10"
    })
    @DisplayName("Calculator should add appropriately")
    public void testAdd(int a, int b, int res){
        assertEquals(res, calc.add(a, b));
    }







}



