package test;

import org.junit.jupiter.api.Test;
import problems.Problem2;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class problem2Test {
    Problem2 p2 = new Problem2();

    @Test
    void simple1() {
        String expr = "+ + 0.5 1.5 * 4 10";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("42.00",res);
    }

    @Test
    void simple2() {
        String expr = "100500.00";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("100500.00",res);
    }

    @Test
    void simple3() {
        String expr = "- -1.5 * 3.1415 / -7 -2";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("-12.50",res);
    }

    @Test
    void simple4() {
        String expr = "* 2 + + 5 -20 - 42 33";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("-12.00",res);
    }

    @Test
    void simpleFail1() {
        String expr = "1 2";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("error",res);
    }

    @Test
    void simpleFail2() {
        String expr = "+ 1";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("error",res);
    }

    @Test
    void divisionByZero() {
        String expr = "/ 1 0";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("∞",res);
    }

    @Test
    void divisionByZero1() {
        String expr = "* -10 - + 6 2 / 8 - 20 49.1";
        String res;
        Stack<String> stack = p2.make_stack(expr);

        res = p2.evaluate(stack);
        assertEquals("-82.75",res);
    }
}