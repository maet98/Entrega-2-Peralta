package com.company;
import org.junit.*;

import jdk.jfr.StackTrace;

import java.util.Random;

public class test {
    @Test
    public void Test1() throws InterruptedException {
        int[] sizes = new int[]{100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600,1700,1800,1900,2000,2100,2200,2300};
        Random r = new Random();
        int ind = r.ints(0,sizes.length+1).findFirst().getAsInt();
        int times = 10;
        int actual = sizes[ind];
        while(times>0){
            Matrix m1 = new ParallelMatrix(actual,actual,true);
            Matrix m2 = new ParallelMatrix(actual,actual,true);
            Matrix s1 = new SequentialMatrix(actual,actual,m1.matrixData);
            Matrix s2 = new SequentialMatrix(actual,actual,m2.matrixData);
            int [][]ParallelResult = m1.multiply(m2);
            int [][]SequentialResult = s1.multiply(s2);
            for(int i = 0;i< actual;i++){
                for(int j = 0;j < actual;j++){
                    assert ParallelResult[i][j]==SequentialResult[i][j];
                }
            }
            times--;
        }
    }
}
