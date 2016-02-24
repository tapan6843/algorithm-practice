/**
 * 
 */
package chapter3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Tapan
 *
 */
public class Question {
	
	private int top1=-1;
	private int top2=10;
	private int size=10;
	private int base3=size/2;
	private int top3=base3;
	private Integer[] dataArray = new Integer[size];
	
	public  void push(int stackId, int data){
		
		if(stackId == 1){
			if(top1+1 == base3){
				if(isStack3RightShiftable()){
					shiftStack3RightShift();
					dataArray[++top1] = data;
				}
			}else{
				dataArray[++top1] = data;
			}
			
		}
		else if(stackId == 2){
			if(top2-1 == base3){
				if(isStack3LeftShiftable()){
					shiftStack3LeftShift();
					dataArray[--top2] = data;
				}
			}else{
				dataArray[--top2] = data;
			}
			
		}
		
		else if(stackId == 3){
			if(top3+1 == top2){
				if(isStack3LeftShiftable()){
					shiftStack3LeftShift();
					dataArray[++top3] = data;
				}
			}else{
				dataArray[++top3] = data;
			}
			
		}
	}
	
	public boolean isStack3RightShiftable(){
		if(top3+1 < top2){
			return true;
		}
		return false;
	}
	
	public void shiftStack3RightShift(){
		for(int i=top3+1;i>=base3+1;i--){
			dataArray[i] = dataArray[i-1];
		}
		dataArray[base3+1] = null;
		top3++;
		
	}
	
	public boolean isStack3LeftShiftable(){
		if(top3-1 > top1){
			return true;
		}
		return false;
	}
	
	public void shiftStack3LeftShift(){
		for(int i=top3-1;i<=base3+1;i++){
			dataArray[i] = dataArray[i+1];
		}
		dataArray[top3--] = null;
		base3--;
	}
	
	public int pop(int stackId){
		
		if(stackId == 1){
			int pop1 = dataArray[top1];
			dataArray[top1--] = null;
			return pop1;
		}
		
		else if(stackId == 2){
			int pop2 = dataArray[top2];
			dataArray[top1++] = null;
			return pop2;
		}
		
		else if(stackId == 3){
			int pop3 = dataArray[top3];
			if(top3-- > base3){
				dataArray[top3--] = null;
			}
			if(top3 == base3){
				dataArray[top3] = null;
			}
			return pop3;
		}
		
		return 0;
	}
	
	public  boolean isStackFull(int stackId){
		
		return false;
	}
	
	public  boolean isEmpty(){
		
		return false;
	}
	
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Push =1 and pop =2");
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String line ="";
		 int count = 1;
		 Question question = new Question();
		 while(count <= 10){
			System.out.println("Enter decision:");
		 	line = br.readLine();
		 	System.out.println("Enter StackID:");
		 	int stackId = Integer.valueOf(br.readLine());
		 	System.out.println("Enter Data:");
	 		int data = Integer.valueOf(br.readLine());
		 	if(line.equals("1")){
		 		question.push(stackId, data);
		 	}
		 	
		 	else if(line.equals("2")){
		 		question.pop(stackId);
		 	}
		 	count++;
		 }
		 
		 for(int i=0; i<question.dataArray.length;i++){
			 System.out.println(question.dataArray[i]);
			 
		 }
	}

}
