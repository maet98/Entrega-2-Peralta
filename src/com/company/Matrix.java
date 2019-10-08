/**
 * 
 */
package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Manuel
 *
 */
public abstract class Matrix 
{
	protected int[][] matrixData;
	protected int columnDimension;
	protected int rowDimension;
	protected Random rObject;
	protected static final int RANDOM_SCALE = 100;
	
	/**
	 * Default constructor
	 */
	public Matrix()
	{
	}
	
	/**
	 * Constructor #1 - El contenido de la matriz se genera aleatoriamente
	 * @param rDimension
	 * @param cDimension
	 */
	public Matrix(int rDimension, int cDimension)
	{
		rObject = new Random(System.currentTimeMillis());
		this.rowDimension = rDimension;
		this.columnDimension = cDimension;
		
		matrixData = new int[this.rowDimension][this.columnDimension];
				
		for(int i = 0; i < rowDimension; i++)
		{
			for(int j = 0; j < columnDimension; j++)
			{
				matrixData[i][j] = (int)(RANDOM_SCALE*Math.random());
			
			}//end-for(1)
		
		}//end-for(2)
	}
	
	/**
	 * Constructor #2 - Se asume que el contenido de la matriz se pasa como parametro
	 * @param rDimension
	 * @param cDimension
	 * @param mData
	 */
	public Matrix(int rDimension, int cDimension, int[][] mData)
	{
		this.rowDimension = rDimension;
		this.columnDimension = cDimension;
		this.matrixData = mData;
	}
	
	/**
	 * Se accede a una entrada en particular de la matriz
	 * 
	 * @param rowPosition
	 * @param columnPosition
	 * @return
	 */
	public int getEntry(int rowPosition, int columnPosition)
	{
		return this.matrixData[rowPosition][columnPosition];
	}
	
	/**
	 * Se obtiene una copia del vector fila cuyo indice se pasa como parametro
	 * @param i
	 * @return
	 */
	public int[] getRowVector(int i)
	{
		return this.matrixData[i].clone();
	}
	
	public int[] getColumnVector(int i)
	{
		int[] columnVector = new int[this.columnDimension];
		
		for(int k = 0; k < this.rowDimension; k++)
			columnVector[k] = matrixData[k][i];
		
		return columnVector.clone();
	}
	
	/**
	 * Devuelve el numero de filas 
	 * @return
	 */
	public int getRowDimension()
	{
		return this.rowDimension;
	}
	
	/**
	 * Devuelve el numero de columnas
	 * @return
	 */
	public int getColumnDimension()
	{
		return this.columnDimension;
	}
	
	public String toString()
	{		
		StringBuffer returnValue = new StringBuffer();
		
		for(int i = 0; i < this.rowDimension; i++)
		{
			returnValue.append(Arrays.toString(this.matrixData[i]) + "\n");
		}
		
		return returnValue.toString();
	}
	
	/**
	 * Declaracion abstracta del metodo cuya implementacion sera 
	 * el algoritmo de multiplicacion de matrices
	 * 
	 * @param secondMatrix
	 * @return
	 */
	public abstract int[][] multiply(Matrix secondMatrix) throws InterruptedException;
	

}
