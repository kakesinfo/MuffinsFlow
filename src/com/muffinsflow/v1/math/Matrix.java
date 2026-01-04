package com.muffinsflow.v1.math;

/**
 * 
 * @author KakesInfo
 *
 */
public class Matrix
{
	private float[][] matrix;

	/**
	 * 
	 * @param columns
	 * @param rows
	 */
	public Matrix(int columns, int rows)
	{
		matrix = new float[columns][rows];
	}
	
	/**
	 * 
	 * @param matrix
	 */
	public Matrix(float[][] matrix)
	{
		this.matrix = matrix;
	}
	
	/**
	 * 	
	 * @param matrix
	 * @return
	 */
	public Matrix add(Matrix matrix)
	{
		int n1 = this.matrix[0].length;
		int m2 = matrix.getMatrix().length;
		
		if (n1 != m2)
			throw new RuntimeException("Illegal matrix dimensions.");

		float[][] result = new float[getColumns()][matrix.getRows()];

		for (int i = 0; i < getColumns(); i++)
		{
			for (int j = 0; j < matrix.getRows(); j++)
			{
					result[i][j] += this.matrix[i][j];
			}
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return 
	 */
	public Matrix multiply(Matrix matrix)
	{
		int n1 = this.matrix[0].length;
		int m2 = matrix.getMatrix().length;
		
		if (n1 != m2)
			throw new RuntimeException("Illegal matrix dimensions.");

		float[][] result = new float[getColumns()][matrix.getRows()];

		for (int i = 0; i < getColumns(); i++)
		{
			for (int j = 0; j < matrix.getRows(); j++)
			{
				for (int k = 0; k < getRows(); k++)
				{
					result[i][j] += this.matrix[i][k];
					result[i][j] *= matrix.getMatrix()[k][j];
				}
			}
		}

		this.matrix = result;

		return this;
	}	
	
	/**
	 * 
	 * @return
	 */
	public Matrix exp()
	{
		for (int x = 0; x < matrix.length; x++)
			for (int y = 0; y < matrix[0].length; y++)
				matrix[x][y] = (float) Math.exp(-matrix[x][y]);

		return this;
	}

	/**
	 * 
	 * @return
	 */
	public Matrix sigmoid()
	{
		float[][] expMatrix = this.exp().getMatrix();

		for (int x = 0; x < matrix.length; x++)
			for (int y = 0; y < matrix[0].length; y++)
				matrix[x][y] = (float) (1 / (1 + expMatrix[x][y]));

		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix random()
	{
		for (int i = 0; i < getColumns(); i++)
		{
			for (int j = 0; j < getRows(); j++)
			{
				matrix[i][j] = (float) Math.random();
			}
		}
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix negate()
	{
		for (int i = 0; i < getColumns(); i++)
			for (int j = 0; j < getRows(); j++)
				matrix[i][j] *= -1;

		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix clone()
	{
		return new Matrix(matrix);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getColumns()
	{
		return matrix.length;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRows()
	{
		return matrix[0].length;
	}

	/**
	 * 
	 * @return
	 */
	public float[][] getMatrix()
	{
		return matrix;
	}
	
	/**
	 * 
	 * @return
	 */
	public int length()
	{
		return matrix.length;
	}

}
