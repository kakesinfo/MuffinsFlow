package com.muffinsflow.v2.layer;

import java.util.*;

import com.muffinsflow.v2.math.*;

public class Layer
{	
	private List<Node> nodes;
	
	public Layer()
	{
		nodes = new ArrayList<>();
	}
	
	public Matrix forward(Matrix inputs)
	{
		return null;
	}
	
	public void backward(Matrix inputs, Matrix ouputs)
	{
		
	}

	public int size()
	{
		return nodes.size();
	}

	public List<Node> getNodes()
	{
		return nodes;
	}
}
