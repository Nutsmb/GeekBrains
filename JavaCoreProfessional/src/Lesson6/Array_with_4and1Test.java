package Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Array_with_4and1Test {
    private Array_with_4and1 array_with_1_4;
    private int[] testArray;
    private boolean expectAnswer;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {true,  new int[]{7, 2, 22, 1, 12, 4, 1, 1, 34, 3, 6}},
                {true,  new int[] {18, 2, 5, 78, 1, 23, 3, 0, 4, 1, 1}},
                {true,  new int[] {1, 2, 5, 9, 11, 23, 12, 0, 34, 3, 6}},
                {true,  new int[] {55, 2, 5, 9, 11, 23, 12, 0, 34, 3, 1}},
                {true,  new int[] {8, 2, 5, 9, 11, 1, 12, 0, 34, 3, 6}},
                {false, new int[] {8, 2, 5, 9, 11, 9, 12, 0, 34, 3, 6}},
                {true,  new int[] {4, 2, 5, 4, 11, 23, 4, 0, 34, 3, 6}},
                {true,  new int[] {7, 2, 22, 4, 12, 9, 4, 4, 34, 3, 6}},
                {true,  new int[] {18, 2, 5, 78, 4, 23, 3, 0, 34, 4, 4}},
                {true,  new int[] {4, 2, 5, 9, 11, 23, 12, 0, 34, 3, 6}},
                {true,  new int[] {55, 2, 5, 9, 11, 23, 12, 0, 34, 3, 4}},
                {true,  new int[] {8, 2, 5, 9, 11, 4, 12, 0, 34, 3, 6}},
                {false, new int[] {8, 2, 5, 9, 11, 9, 12, 0, 34, 3, 6}}
        });
    }

    public Array_with_4and1Test(boolean expectAnswer, int[] testArray){
        this.testArray = testArray;
        this.expectAnswer = expectAnswer;
    }

    @Before
    public void init(){
        array_with_1_4 = new Array_with_4and1();
    }

    @Test
    public void MasstestFourandOne() {
        Assert.assertEquals(expectAnswer, array_with_1_4.checkFor1and4(testArray));
    }
}