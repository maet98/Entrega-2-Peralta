package com.company;

public class MultiplierThread extends Thread
{

    private int[] rowVector;
    private int[][] Matrix;
    private int[] result;

    /**
     * Constructor parametrizado
     *
     * @param rowVector
     * @param Matrix
     */
    public MultiplierThread(int[] rowVector, int[][] Matrix)
    {
        this.setRowVector(rowVector);
        this.setMatrix(Matrix);
        this.result = new int[rowVector.length];
    }

    public int[] getRowVector() {
        return rowVector;
    }

    public void setRowVector(int[] rowVector) {
        this.rowVector = rowVector;
    }

    public int[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(int[][] Matrix) {
        this.Matrix = Matrix;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int result[]) {
        this.result = result;
    }

    /**
     *
     */
    public void run()
    {
        int n = rowVector.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                result[i] += (rowVector[j]*Matrix[j][i]);
            }
        }
    }


}
