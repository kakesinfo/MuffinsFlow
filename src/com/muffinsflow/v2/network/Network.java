package com.muffinsflow.v2.network;

import java.util.*;

import com.muffinsflow.v2.layer.*;
import com.muffinsflow.v2.math.*;

public class Network
{
	private List<Layer> layers;

	public Network(int inputLayerSize, int outputLayerSize)
	{
		
	}
	
	public void backward(Matrix inputs, Matrix ouputs)
	{

	}

	public Matrix forward(Matrix inputs)
	{
		return null;
	}

	public static NetworkBuilder getBuilder()
	{
		return new NetworkBuilder();
	}

	public List<Layer> getLayers()
	{
		return layers;
	}
}
