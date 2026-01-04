package com.muffinsflow.v2;

import com.muffinsflow.v2.network.*;

public class Main
{

	public static void main(String[] args)
	{
		Network network = Network.getBuilder()
		.setInputLayerSize(2)
		.setOutputLayerSize(1)
		.build();
		
		network.backward(null, null);
		
		network.forward(null);
	}

}
