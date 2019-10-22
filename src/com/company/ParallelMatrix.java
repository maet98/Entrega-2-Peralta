/**
 *
 */
package com.company;


/**
 * @author Miguel y Wladimir
 *
 */
public class ParallelMatrix extends Matrix {

    /* (non-Javadoc)
     * @see base.Matrix#multiply(base.Matrix)
     */
    private boolean cell;

    /**
     * Constructor parametrizado
     *
     * @param rDimension
     * @param cDimension
     */
    public ParallelMatrix(int rDimension, int cDimension, boolean cell) {
        super(rDimension, cDimension);
        this.setCell(cell);
    }

    public boolean isCell() {
        return cell;
    }

    public void setCell(boolean cell) {
        this.cell = cell;
    }

    @Override
    public double[][] multiply(Matrix secondMatrix) throws InterruptedException {
        double result[][] = new double[this.rowDimension][this.columnDimension];
        if (!cell) {
            MultiplierThread[] threads = new MultiplierThread[this.rowDimension];
            for (int i = 0; i < this.rowDimension; i++) {
                threads[i] = new MultiplierThread(this.matrixData[i], secondMatrix.matrixData);
                threads[i].start();
            }
            for (MultiplierThread thread : threads) {
                thread.join();
            }
            for (int i = 0; i < this.rowDimension; i++) {
                result[i] = threads[i].getResult();
            }
        } else {
            MultiplierThreadCell[][] threads = new MultiplierThreadCell[ this.rowDimension][this.columnDimension];
            for (int i = 0; i < this.rowDimension; i++) {
                for (int j = 0; j < this.columnDimension; j++) {
                    threads[i][j] = new MultiplierThreadCell(this.matrixData[i], secondMatrix.getColumnVector(j));
                    threads[i][j].start();
                }
            }
            for (int i = 0; i < this.rowDimension; i++) {
                for (int j = 0; j < this.columnDimension; j++) {
                    threads[i][j].join();
                }
            }
            for (int i = 0; i < this.rowDimension; i++) {
                for (int j = 0; j < this.columnDimension; j++) {
                    result[i][j] = threads[i][j].getResult();
                }
            }
        }
        return result;

    }
}