package Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Arrays_with_4Test {
    private Arrays_with_4 arrays_with_4;
    private int[] testArray;
    private int[] expectArray;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {new int[] {4, 2, 5, 9, 11, 23, 12, 0, 34, 3, 6},   new int[] {2, 5, 9, 11, 23, 12, 0, 34, 3, 6}},
                {new int[] {1, 2, 5, 9, 11, 23, 12, 0, 34, 3, 4},   new int[] {}},
                {new int[] {8, 2, 5, 9, 11, 4, 12, 0, 34, 3, 6},    new int[] {12, 0, 34, 3, 6}}
        });
    }

    public Arrays_with_4Test(int[] testArray, int[] expectArray){
        this.testArray = testArray;
        this.expectArray = expectArray;
    }

    @Before
    public void init(){
        arrays_with_4 = new Arrays_with_4();
    }

    @Test
    public void MasstestDiffPositionFour() {
        Assert.assertArrayEquals(expectArray, arrays_with_4.getAfterLast4(testArray));
    }
}