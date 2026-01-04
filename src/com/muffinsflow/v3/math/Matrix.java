package com.muffinsflow.v3.math;

public class Matrix
{
	public int rows, columns;

	public float[][] values;

	public Matrix(float[][] values) {
		this(values.length, values[0].length);
		this.values = values;
	}

	public Matrix(int rows, int columns) {
		this.values = new float[rows][columns];
		this.rows = rows;
		this.columns = columns;
	}

	public Matrix add(Matrix matrix)
	{
		if (matrix.rows != rows)
			throw new Error("Can't add 2 matrix with different rowss");
		if (matrix.columns != columns)
			throw new Error("Can't add 2 matrix with different columnss");

		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < columns; y++)
			{
				this.values[x][y] += values[x][y];
			}
		}

		return this;
	}

	public Matrix multiply(int integer)
	{
		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < columns; y++)
			{
				this.values[x][y] *= integer;
			}
		}

		return this;
	}

	public Matrix multiply(Matrix matrix)
	{
		if (columns != matrix.rows)
			throw new Error("Can't multiply 2 matrix with no appropriate dimensions");

		float[][] n_values = new float[rows][matrix.columns];

		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < matrix.columns; y++)
			{
				for (int z = 0; z < columns; z++)
				{
					n_values[x][y] += values[x][z] * matrix.values[z][y];
				}
			}
		}

		return new Matrix(n_values);
	}

	public Matrix pow(int integer)
	{
		Matrix matrix = new Matrix(values);
		
		for (int i = 0; i < integer; i++)
		{
			matrix = multiply(matrix);
		}
		
		return matrix;
	}

	public Matrix clone()
	{
		Matrix matrix = new Matrix(rows, columns);

		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < columns; y++)
			{
				matrix.values[x][y] = values[x][y];
			}
		}

		return matrix;
	}

	public void debug()
	{
		for (int x = 0; x < rows; x++)
		{
			System.out.print("{ ");
			for (int y = 0; y < columns; y++)
			{
				System.out.print(values[x][y] + " ");
			}
			System.out.println("}");
		}

		System.out.println("");
	}
}
