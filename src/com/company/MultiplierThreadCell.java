package com.company;

public class MultiplierThreadCell extends Thread
{

    private double[] rowVector;
    private double[] columnVector;
    private double result;

    /**
     * Constructor parametrizado
     *  @param rowVector
     * @param columnVector
     */
    public MultiplierThreadCell(double[] rowVector, double[] columnVector)
    {
        this.setRowVector(rowVector);
        this.setColumnVector(columnVector);
        this.result = 0;
    }

    public double[] getRowVector() {
        return rowVector;
    }

    public void setRowVector(double[] rowVector) {
        this.rowVector = rowVector;
    }

    public double[] getColumnVector() {
        return columnVector;
    }

    public void setColumnVector(double[] columnVector) {
        this.columnVector = columnVector;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    /**
     *
     */
    public void run()
    {
        int n = rowVector.length;
        for(int i = 0;i < n;i++){
            result = columnVector[i]*rowVector[i];
        }
    }


}