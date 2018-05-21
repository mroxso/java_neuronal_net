package de.pascalrost.neuronalnet;

import java.util.ArrayList;

public class Network {

	ArrayList<Neuron> input = new ArrayList<Neuron>();
	ArrayList<Neuron> hidden = new ArrayList<Neuron>();
	ArrayList<Neuron> output = new ArrayList<Neuron>();

	public Network(int input, int hidden, int output)
	{
		for(int i = 0; i < input; i++)
		{
			this.input.add(new Neuron(this.hidden));
		}
		for(int i = 0; i < hidden; i++)
		{
			this.hidden.add(new Neuron(this.output));
		}
		for(int i = 0; i < output; i++)
		{
			this.output.add(new Neuron(null));
		}
	}
	
	public int[] compute(double[] inputVektor)
	{
		int[] inputResult = new int[this.input.size()];
		int[] hiddenResult = new int[this.input.size()];
		int[] outputResult = new int[this.input.size()];
		
		for(int i = 0; i < this.input.size(); i++)
		{
			inputResult[i] = this.input.get(i).fire(inputVektor);
		}
		for(int i = 0; i < this.hidden.size(); i++)
		{
			hiddenResult[i] = this.hidden.get(i).fire(inputResult);
		}
		for(int i = 0; i < this.output.size(); i++)
		{
			outputResult[i] = this.output.get(i).fire(hiddenResult);
		}
		return outputResult;
	}
	
	public void train(double[] input, int result) {
		
		// Train Input
		for(int i = 0; i < this.input.size(); i++) {
			this.input.get(i).train(input, result);
		}
		
		// Train Hidden
		for(int i = 0; i < this.hidden.size(); i++) {
			this.hidden.get(i).train(input, result);
		}
		
		// Train Output
		for(int i = 0; i < this.output.size(); i++) {
			this.output.get(i).train(input, result);
		}
	}
	
}
