package com.muffinsflow.v1.network;

import java.util.*;

import com.muffinsflow.v1.math.*;

/**
 * 
 * @author KakesInfo
 *
 */
public class Network
{
	private Layer[] layers;

	private int inputLayerSize;
	private int outputLayerSize;
	
	/**
	 * <p>
	 * The Network class able you to build a Neural Network. 
	 * You just need to put the input layer's size, the output 
	 * layer's size and finally each hidden layers' size.
	 * </p>
	 * 
	 * @param inputLayerSize -> The input layer's size 
	 * @param outputLayerSize -> The output layer's size 
	 * @param hiddenLayersSize -> The list of each hidden layers' size 
	 */
	public Network(int inputLayerSize, int outputLayerSize, List<Integer> hiddenLayersSize)
	{
		this.inputLayerSize = inputLayerSize;
		this.outputLayerSize = outputLayerSize;
		
		int hiddenLayers = hiddenLayersSize.size();

		layers = new Layer[hiddenLayers + 2];
		layers[0] = new Layer(inputLayerSize);

		for (int i = 0; i < hiddenLayers; i++)
			layers[i + 1] = new Layer(hiddenLayersSize.get(i));

		layers[hiddenLayers + 1] = new Layer(outputLayerSize);

		for (Layer layer : layers)
			layer.bind(layers);
	}
	
	/**
	 * <p>
	 * The method which applies the Forward propagation on the Neural Network
	 * using a Matrix containing all inputs and returning a Matrix of all ouputs.
	 * </p>
	 * 
	 * @param inputs -> The Matrix containing all inputs 
	 * 
	 * @return It returns a Matrix containing all ouputs
	 */
	public Matrix forward(Matrix inputs)
	{
		return layers[0].forward(inputs);
	}
	
	/**
	 * <p>
	 * The method which is used for training the Neural Network.
	 * Using the Backward propagation, you need to feed the netword with 
	 * two Matrix: on of all training inputs and the other for
	 * </p>
	 * 
	 * @param trainingInputs -> The Matrix containing all training inputs
	 * @param trainingOuputs -> The Matrix containing all training outputs
	 */
	public void backward(Matrix trainingInputs, Matrix trainingOuputs)
	{
		layers[layers.length - 1].backward(trainingInputs, trainingOuputs);
	}
	
	/**
	 * 
	 * @return It returns this network's builder
	 */
	public static NetworkBuilder getBuilder()
	{
		return new NetworkBuilder();
	}
	
	/**
	 * 
	 * @return It returns the input layer size's Integer
	 */
	public int getInputLayerSize()
	{
		return inputLayerSize;
	}
	
	/**
	 * 
	 * @return It returns the ouput layer size's Integer
	 */
	public int getOutputLayerSize()
	{
		return outputLayerSize;
	}
	
	/**	 
	 * 
	 * @return It returns the hidden layers' array
	 */
	public Layer[] getHiddenLayers()
	{
		return layers;
	}
}
