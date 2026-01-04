package com.muffinsflow.v1.network;

import java.util.*;

/**
 * 
 * @author KakesInfo
 *
 */
public class NetworkBuilder
{
	private List<Integer> hiddenLayersSize;
	
	private int inputLayerSize;
	private int outputLayerSize;
	
	/**
	 * <p>
	 * The Network Builder class able you to build in a easier way your own Network.
	 * </p>
	 */
	public NetworkBuilder()
	{
		hiddenLayersSize = new ArrayList<>();
		
		inputLayerSize = 1;
		outputLayerSize = 1;
	}
	
	/**
	 * <p>
	 * This method able you to set a default schematic network patern.</br>
	 * Exemple: You can set Schematic.FEED_FORWARD
	 * </p>
	 * 
	 * @param schematic -> The chosen schematic network patern
	 * 
	 * @return It returns the network Builder's instance
	 */
	public NetworkBuilder setSchematic(Schematic schematic)
	{
		hiddenLayersSize = schematic.getHiddenLayersSize();
		
		inputLayerSize = schematic.getInputLayerSize();
		
		outputLayerSize = schematic.getOutputLayerSize();
		
		return this;		
	}
	
	/**
	 * <p>
	 * This method able you to add a new default Hidden Layer to you Network 
	 * with a certain size.
	 * </p>
	 * 
	 * @param hiddenLayerSize -> The new hidden layer's size
	 * 
	 * @return It returns the network Builder's instance
	 */
	public NetworkBuilder newHiddenLayer(int hiddenLayerSize)
	{
		hiddenLayersSize.add(hiddenLayerSize);
		
		return this;
	}
	
	/**
	 * <p>
	 * This method able you to set the default input layer's size
	 * </p>
	 * 
	 * @param inputLayerSize -> The input layer's size
	 * 
	 * @return It returns the network Builder's instance
	 */
	public NetworkBuilder setInputLayerSize(int inputLayerSize)
	{
		this.inputLayerSize = inputLayerSize;

		return this;
	}

	/**
	 * <p>
	 * This method able you to set the default output layer's size
	 * </p>
	 * 
	 * @param outputLayerSize -> The output layer's size 
	 * 
	 * @return It returns the network Builder's instance
	 */
	public NetworkBuilder setOutputLayerSize(int outputLayerSize)
	{
		this.outputLayerSize = outputLayerSize;

		return this;
	}
	
	/**
	 * <p>
	 * This method able you to build your Network
	 * </p>
	 * 
	 * @return It returns you new Network
	 */
	public Network build()
	{
		return new Network(inputLayerSize, outputLayerSize, hiddenLayersSize);
	}
}
