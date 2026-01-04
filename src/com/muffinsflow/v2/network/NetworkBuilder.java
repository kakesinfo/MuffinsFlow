package com.muffinsflow.v2.network;

public class NetworkBuilder
{
	private int inputLayerSize;
	private int outputLayerSize;
	
	public NetworkBuilder()
	{
		
	}

	public NetworkBuilder setInputLayerSize(int size)
	{
		this.inputLayerSize = size;
		
		return this;
	}
	
	public NetworkBuilder setOutputLayerSize(int size)
	{
		this.outputLayerSize = size;
		
		return this;
	}
	
	public Network build()
	{
		Network network = new Network(inputLayerSize, outputLayerSize);
		
		return network;		
	}
}
