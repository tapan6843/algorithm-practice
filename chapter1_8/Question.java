/**
 * 
 */
package chapter1_8;

import java.util.HashMap;

/**
 * @author Tapan
 *
 */
public class Question {
	
	public static boolean isStringRoatated(String first,String second){
		
		if(first.length() != second.length()|| first.equals(second)){
			return false;
		}
		
		if(first != null && second != null){
			char[] firstArr = first.toCharArray();
			char[] secondArr = second.toCharArray();
			int stringLen = first.length();
			HashMap<Character,Integer> countMap = new HashMap<Character,Integer>();
			for(int i=0;i < stringLen;i++){
				char firstArrChar = firstArr[i];
				if(countMap.containsKey(firstArrChar)){
					int count =countMap.get(firstArrChar);
					count = count + 1;
					if(count > 0){
						countMap.put(firstArrChar,count);
					}else{
						countMap.remove(firstArrChar);
					}
				}else{
					countMap.put(firstArrChar,1);
				}
				
				char secondArrChar = secondArr[i];
				if(countMap.containsKey(secondArrChar)){
					int countVal = countMap.get(secondArrChar);
					countVal = countVal - 1;
					if(countVal != 0){
						countMap.put(secondArrChar,countVal);
					}else{
						countMap.remove(secondArrChar);
					}
				}else{
					countMap.put(secondArrChar,-1);
				}
			}
			
			if(countMap.size() > 0){
				return false;
			}else{
				return true;
			}
			
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("String are roated:" +isStringRoatated("camera","macera"));
	}

}
