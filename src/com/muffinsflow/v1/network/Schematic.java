package com.muffinsflow.v1.network;

import java.util.*;

/**
 * 
 * @author KakesInfo
 *
 */
public enum Schematic
{
	FEED_FORWARD(2, 1, 3);
	
	private List<Integer> hiddenLayersSize;
	
	private int inputLayerSize;
	private int outputLayerSize;

	/**
	 * <p>
	 * The Schematic class make your life easier. 
	 * It able you to pre-setup a Network with a certain patern.
	 * </p>
	 * 
	 * @param inputLayerSize -> The schematic's input layer's size
	 * @param outputLayerSize -> The schematic's output layer's size
	 * @param hiddenLayersSize -> The schematic's hidden layers' size
	 */
	private Schematic(int inputLayerSize, int outputLayerSize, int... hiddenLayersSize)
	{
		this.inputLayerSize = inputLayerSize;
		this.outputLayerSize = outputLayerSize;
	
		this.hiddenLayersSize = new ArrayList<>();
		
		for(int size : hiddenLayersSize)
			this.hiddenLayersSize.add(size);
	}
	
	/**
	 * 
	 * @return It returns all schematic's Hidden layers' size
	 */
	public List<Integer> getHiddenLayersSize()
	{
		return hiddenLayersSize;
	}
	
	/**
	 * 
	 * @return It returns the schematic's Input layer's size
	 */
	public int getInputLayerSize()
	{
		return inputLayerSize;
	}
	
	/**
	 * 
	 * @return It returns the schematic's Output layer's size
	 */
	public int getOutputLayerSize()
	{
		return outputLayerSize;
	}
}
