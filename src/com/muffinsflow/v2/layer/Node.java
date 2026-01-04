package com.muffinsflow.v2.layer;

import java.util.*;

import com.muffinsflow.v2.math.*;

public class Node
{
	private Layer layer;
	
	private Layer leftLayer;
	private Layer rightLayer;
	
	private Matrix weights;
	private Matrix images;
	private Matrix activations;
	
	public Node(Layer layer)
	{
		this.layer = layer;
	}
	
	public void bind(List<Layer> layers)
	{
		int index = 0;

		for (Layer layer : layers)
		{
			if (layer == this.layer)
				continue;
						
			index++;
		}

		if (index - 1 >= 0)
			leftLayer = layers.get(index - 1);

		if (index + 1 < layers.size())
			rightLayer = layers.get(index + 1);
		
		weights = new Matrix(1, rightLayer.size());
	}

	public Layer getLayer()
	{
		return layer;
	}

	public Layer getLeftLayer()
	{
		return leftLayer;
	}

	public Layer getRightLayer()
	{
		return rightLayer;
	}

	public Matrix getWeights()
	{
		return weights;
	}

	public Matrix getImages()
	{
		return images;
	}

	public Matrix getActivations()
	{
		return activations;
	}
}
