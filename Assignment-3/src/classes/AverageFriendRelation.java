/**
 * 
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tapan
 *
 */
public class AverageFriendRelation {
	
	private Graph graph;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AverageFriendRelation relation = new AverageFriendRelation();
		
		relation.buildGraph();
		
		int totalSumDistance =0; //Sum of distnace of all 4039 Vertex.
		
		
		for(int i=0;i<Graph.TOTAL_VERTEX;i++){
			
			int totalVertexDistance = relation.getTotalDistanceToEachFrnd(i);
			
			totalSumDistance = totalSumDistance+totalVertexDistance;
		}
		
		double average = totalSumDistance/Graph.TOTAL_VERTEX;
		
		System.out.println("Average seprating two users is: "+ Math.round(average*100.00)/100.00); // Final Average
	}
	
	/**
	 * Builds the graph.
	 */
	public void buildGraph(){
		
		try {
			graph = new Graph();
			/*
			 * REF: http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
			 * Create input file and write values 
			 * */
			Path path = Paths.get("facebook_combined.txt");
			
			/*Read from created input file*/
			File inputFile = path.toFile();
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			
			String line = reader.readLine();
			while(line != null){
				
				String[] splitVal = line.split(" ");
				int source = Integer.parseInt(splitVal[0]);
				int destination = Integer.parseInt(splitVal[1]);
				
				graph.addEdge(source, destination);// add edge to graph 
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalDistanceToEachFrnd(int sourceId){
		
		int totalDistance =0;
		
		boolean[] filter = new boolean[Graph.TOTAL_VERTEX];
		
		if (graph != null) {
			Queue queue = new Queue();
			ListNode sourceNode = graph.getList()[sourceId];
			if (sourceNode != null) {
				filter[sourceId] = true;
				sourceNode.setLevel(0);
				queue.enqueue(sourceNode);
				while (!queue.isEmpty()) {
					ListNode visitedNode = queue.dequeue();
					int parentLevel = visitedNode.getLevel();
					ListNode headNode = graph.getList()[visitedNode.getData()];
					while (headNode != null) {
						headNode = headNode.getNext();
						if (headNode != null) {
							if (!filter[headNode.getData()]) {
								filter[headNode.getData()] = true;
								headNode.setLevel(parentLevel + 1);
								totalDistance = totalDistance
										+ headNode.getLevel();
								queue.enqueue(headNode);
							}
						}
					}
				}
			}
		}
		return totalDistance;
		
	}

}
