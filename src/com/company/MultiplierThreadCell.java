package com.company;

public class MultiplierThreadCell extends Thread
{

    private int[] rowVector;
    private int[] columnVector;
    private int result;

    /**
     * Constructor parametrizado
     *
     * @param rowVector
     * @param columnVector
     */
    public MultiplierThreadCell(int[] rowVector, int[] columnVector)
    {
        this.setRowVector(rowVector);
        this.setColumnVector(columnVector);
        this.result = 0;
    }

    public int[] getRowVector() {
        return rowVector;
    }

    public void setRowVector(int[] rowVector) {
        this.rowVector = rowVector;
    }

    public int[] getColumnVector() {
        return columnVector;
    }

    public void setColumnVector(int[] columnVector) {
        this.columnVector = columnVector;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
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