package com.company;
;

public class SequentialMatrix extends Matrix
{

    public SequentialMatrix(int rDimension, int cDimension)
    {
        super(rDimension, cDimension);
        // TODO Auto-generated constructor stub
    }

    public SequentialMatrix(int rDimension, int cDimension, double[][] matrixData) {
        super(rDimension,cDimension,matrixData);
    }

    @Override
    public double[][] multiply(Matrix secondMatrix)
    {
        double[][] resultMatrix = new double[this.columnDimension][secondMatrix.getRowDimension()];
        for(int i = 0;i< rowDimension;i++){
            for(int j = 0;j < columnDimension;j++){
                for(int k = 0;k < columnDimension;k++){
                    resultMatrix[i][j] += this.matrixData[i][k]*secondMatrix.matrixData[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
