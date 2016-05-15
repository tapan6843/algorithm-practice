/**
 * 
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tapan
 *
 */
public class FriendRelationShip {
	
	
	private Graph graph;
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FriendRelationShip relationShip = new FriendRelationShip();
		
		relationShip.buildGraph();
		
		int sourceId = Integer.parseInt(args[0]);
		int destinationId = Integer.parseInt(args[1]);
		
		int mutualFrndCount = relationShip.friendsInCommon(sourceId, destinationId);
		
		if(mutualFrndCount >= 0){
			System.out.println("Users "+sourceId+" and "+destinationId+" are "+ mutualFrndCount+" apart.");
		}else{
			System.out.println("Users "+sourceId+" and "+destinationId+" are not reachable.");
		}

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
	
	/**
	 * Friends in common.
	 *
	 * @param sourceId the source id
	 * @param destinationId the destination id
	 * @return the int
	 */
	public int friendsInCommon(int sourceId,int destinationId){
		
		if (graph != null) {
			Queue queue = new Queue();
			ListNode sourceNode = graph.getList()[sourceId];
			sourceNode.setVisited(true);
			sourceNode.setLevel(0);
			queue.enqueue(sourceNode);
			while(!queue.isEmpty()){
				ListNode visitedNode = queue.dequeue();
				int parentLevel = visitedNode.getLevel();
				ListNode headNode = graph.getList()[visitedNode.getData()];
				while(headNode != null){
					headNode = headNode.getNext();
					if(headNode != null){
						if (headNode.getData() != destinationId) {
							if (!headNode.isVisited()) {
								headNode.setVisited(true);
								headNode.setLevel(parentLevel+1);
								queue.enqueue(headNode);
							}
						}else{
							return parentLevel;
						}
					}
				}
			}
			if(queue.isEmpty()){
				return -1;
			}
		}
		return 0;
	}

}
