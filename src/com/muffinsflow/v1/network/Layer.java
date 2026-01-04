package com.muffinsflow.v1.network;

import com.muffinsflow.v1.math.*;

public class Layer
{
	private Layer leftLayer;
	private Layer rightLayer;

	private Matrix weights;
	private Matrix images;
	private Matrix activations;

	private int size;
	private int bias;
	
	/**
	 * This is the Layer class' constructor
	 * 
	 * @param size -> The layer's size
	 */
	public Layer(int size)
	{
		this.size = size;
	}

	/**
	 * The bind method is made for binding to each layer his last and next layer.
	 * 
	 * @param layers -> The array of all layers
	 */
	public void bind(Layer[] layers)
	{
		int index = 0;

		for (Layer layer : layers)
		{
			if (layer == this)
				continue;
						
			index++;
		}

		if (index - 1 >= 0)
			leftLayer = layers[index - 1];

		if (index + 1 < layers.length)
			rightLayer = layers[index + 1];
	}
	
	/**
	 * 
	 * @param inputs
	 * @return
	 */
	public Matrix forward(Matrix inputs)
	{
		if (rightLayer == null)
			return inputs;

		int rightLayerSize = rightLayer.getSize();

		weights = new Matrix(size, rightLayerSize).random();

		images = inputs.clone().multiply(weights);

		activations = images.clone().sigmoid();
		
		return rightLayer.forward(activations);
	}
	
	/**
	 * 
	 * @param inputs
	 * @param ouputs
	 */
	public void backward(Matrix inputs, Matrix ouputs)
	{
		if(leftLayer == null)
			return;		
		
		int leftLayerSize = leftLayer.getSize();
		
		/*
		 * TODO: Backward propagation calculs
		 */
		
		leftLayer.backward(inputs, ouputs);
	}
	
	/**
	 * 
	 * @return
	 */
	public Layer getLeftLayer()
	{
		return leftLayer;
	}
	
	/**
	 * 
	 * @return
	 */
	public Layer getRightLayer()
	{
		return rightLayer;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix getWeights()
	{
		return weights;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix getImages()
	{
		return images;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix getActivations()
	{
		return activations;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize()
	{
		return size;
	}
}
