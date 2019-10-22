package com.company;

public class MultiplierThread extends Thread
{

    private double[] rowVector;
    private double[][] Matrix;
    private double[] result;

    /**
     * Constructor parametrizado
     *  @param rowVector
     * @param Matrix
     */
    public MultiplierThread(double[] rowVector, double[][] Matrix)
    {
        this.setRowVector(rowVector);
        this.setMatrix(Matrix);
        this.result = new double[rowVector.length];
    }

    public double[] getRowVector() {
        return rowVector;
    }

    public void setRowVector(double[] rowVector) {
        this.rowVector = rowVector;
    }

    public double[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(double[][] Matrix) {
        this.Matrix = Matrix;
    }

    public double[] getResult() {
        return result;
    }

    public void setResult(double result[]) {
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
