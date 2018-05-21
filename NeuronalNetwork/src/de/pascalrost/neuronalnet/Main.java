package de.pascalrost.neuronalnet;

public class Main {

	public static void main(String[] args) {
		
		Network neuronalNetwork = new Network(5, 5, 4);
		
		neuronalNetwork.train(new double[] {42.5}, 1337);
		
		int[] response = neuronalNetwork.compute(new double[] {1564156.7,12.3});
		
		for(int i = 0; i < response.length; i++) {
			System.out.print(response[i] + ",");
		}
	}

}
