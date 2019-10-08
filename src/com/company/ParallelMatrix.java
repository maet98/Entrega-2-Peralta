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
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param rDimension
	 * @param cDimension
	 */
	public ParallelMatrix(int rDimension, int cDimension)
	{
		super(rDimension, cDimension);
	}
	
	@Override
	public int[][] multiply(Matrix secondMatrix) throws InterruptedException {
		int result[][] = new int[this.rowDimension][this.columnDimension];
		MultiplierThread[] threads = new MultiplierThread[this.rowDimension];
		for(int i = 0;i < this.rowDimension;i++){
			threads[i] = new MultiplierThread(this.matrixData[i],secondMatrix.matrixData);
			threads[i].start();
		}
		for(MultiplierThread thread: threads){
			thread.join();
		}
		for(int i =0;i < this.rowDimension;i++){
			result[i] = threads[i].getResult();
		}
		return result;
	}

}
