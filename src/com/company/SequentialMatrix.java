package com.company;
;

public class SequentialMatrix extends Matrix
{

    public SequentialMatrix(int rDimension, int cDimension)
    {
        super(rDimension, cDimension);
        // TODO Auto-generated constructor stub
    }

    public SequentialMatrix(int rDimension, int cDimension, int[][] matrixData) {
        super(rDimension,cDimension,matrixData);
    }

    @Override
    public int[][] multiply(Matrix secondMatrix)
    {
        int[][] resultMatrix = new int[this.columnDimension][secondMatrix.getRowDimension()];
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
