package com.muffinsflow.v1;

import static com.muffinsflow.v1.network.Schematic.*;

import com.muffinsflow.v1.math.*;
import com.muffinsflow.v1.network.*;

public class Main
{
	static float[][] trainingInputs = { { 3, 5 }, { 5, 1 }, { 10, 2 } };
	static float[][] trainingOuputs = { { 0.75f }, { 0.82f }, { 0.93f } };

	static float[][] inputs = { { 5, 8 } };
	
	public static void main(String[] args)
	{
		
		Network network = Network.getBuilder()
				.setSchematic(FEED_FORWARD)
				.newHiddenLayer(3)
				.build();
						
		network.backward(new Matrix(trainingInputs), new Matrix(trainingOuputs));
				
		Matrix ouputs = network.forward(new Matrix(inputs));

		System.out.println(trainingOuputs[0][0] + " " + ouputs.getMatrix()[0][0]);
	}

}
