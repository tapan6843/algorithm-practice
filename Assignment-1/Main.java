import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Tapan,Niket and Dhiral
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			/*Read from created input file*/
			File inputFile = new File("input.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			
			String line = reader.readLine();
			
			Stack stack = new Stack(); // Intialize stack
			Queue queue = new Queue(); // Intialize queue
			
			while(line != null){
				int inputValue = Integer.parseInt(line);
				stack.push(inputValue); //Add value to stack
				queue.add(inputValue); //Add value to queue
				line = reader.readLine();
			}
			
			System.out.println("========Stack Value==========");
			Integer stackVal = stack.pop(); //Delete data from stack
			while(stackVal != null){
				System.out.println(stackVal);
				stackVal = stack.pop(); //Delete data from stack
			}
			
			System.out.println("=========Queue Value=========");
			Integer queueVal = queue.delete(); //Delete data from queue
			while(queueVal != null){
				System.out.println(queueVal);
				queueVal = queue.delete(); //Delete data from queue
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
