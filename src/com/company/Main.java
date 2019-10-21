package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nanoseconds = 1000000000;
        int[] sizes = new int[]{100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600,1700,1800,1900,2000,2100,2200,2300};
        for(int actual: sizes){
            double t1,t2;
            t1 = t2 = 0;
            int times = 10;
            while(times>0){
                Matrix m1 = new ParallelMatrix(actual,actual,true);
                Matrix m2 = new ParallelMatrix(actual,actual,true);
                Matrix s1 = new SequentialMatrix(actual,actual,m1.matrixData);
                Matrix s2 = new SequentialMatrix(actual,actual,m2.matrixData);
                long start = System.nanoTime();
                int [][]result = m1.multiply(m2);
                t1 += (double)(System.nanoTime()-start)/nanoseconds;
                start = System.nanoTime();
                int [][]r2 = s1.multiply(s2);
                t2 += (double)(System.nanoTime()-start)/nanoseconds;
                times--;
            }
            t1/=10;
            t2/=10;
            System.out.println("For Size: "+actual+" Parrallel: "+t1+" seconds.");
            System.out.println("For Size: "+actual+" Sequential: "+t2+" seconds.");
        }
    }
}
