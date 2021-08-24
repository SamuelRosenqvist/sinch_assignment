package test;

import org.junit.jupiter.api.Test;
import problems.Problem1;

import static org.junit.jupiter.api.Assertions.*;

class problem1Test {
    Problem1 p1 = new Problem1();

    @Test
    void simple1() {
        int k = 6;
        int[] arr = {2,1,4,5,3};
        int res = p1.findSums(k,arr);
        assertEquals(2,res);
    }

    @Test
    void simple2() {
        int k = 1;
        int[] arr = {1,1,1,1,0};
        int res = p1.findSums(k,arr);
        assertEquals(4,res);
    }

    @Test
    void simple3() {
        int k = 10;
        int[] arr = {9,0,3,15,2,4,1,-5};
        int res = p1.findSums(k,arr);
        assertEquals(2,res);
    }
}