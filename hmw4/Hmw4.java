//package javaFirst;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import java.util.*;
public class Hmw4 {

	public static void main(String[] argc)
	{
		
		Hmw4 obj = new Hmw4();
		//Q1 TEST
		String q1 = "aabbcHacicmvHaci";
		System.out.println("Q1 Answer: ");
		System.out.println(obj.q1(q1,"Haci",0)); //output: 5
		System.out.println(obj.q1(q1,"Haci",1)); //output: 12
		System.out.println(obj.q1(q1,"Haci",2)); //output: -1
		System.out.println(obj.q1(q1,"Hasan",0)); //output: -1


		System.out.println("\n----------------------");
		//Q2 TEST
		int[] arr = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180};
		int count = obj.q2(arr,2,62,0); //result: 6
		System.out.println("Q2 Answer1: "+ count);

		int count2 = obj.q2(arr,12,179,0);
		System.out.println("Q2 Answer2: "+ count2); //result: 16 
		System.out.println("\n----------------------");
		
		//Q3 TEST
		int[] arr3 = {5,3,8,1,2,11,0,7,5,6,8,4,12,13,15,17,20,2,0,11,10,1,0,1}; 
		System.out.println("Q3 Answer1: (sum: 11)");
		obj.q3(arr3,11);
		System.out.println("-----");
		System.out.println("Q3 Answer2: (sum: 12)");
		obj.q3(arr3,12);
		
		//Q5 TEST
		System.out.println("\n----------------------");
		System.out.println("Q5.1");
		char[] arr2 = new char[7];
		obj.q5(arr2,3);

		System.out.println("\nQ5.2");
		char[] arr2_1 = new char[9];
		obj.q5(arr2_1,3);

	}
	
		
	///------------------------------Q1------------------------------------
	/**
	 * Just uses the q1Helper(...)
	 * @param bigger bigger String that will be worked on it
	 * @param smaller smaller String that will be found
	 * @param i ith occurence
	 * @return index of ith occurence if it's there otherwise return -1
	 */
	public int q1(String bigger, String smaller, int i) {
		
		return q1Helper(bigger,smaller,i,0,smaller.length(),0);
	}
	/**
	 * Checks strings between fi and li if it's equal to smaller return index 
	 * @param bigger bigger String that will be worked on it
	 * @param smaller smaller String that will be found
	 * @param i ith occurence
	 * @param fi first index of the string
	 * @param li last index of the string
	 * @return index of ith occurence if it's there otherwise return -1
	 */
	public int q1Helper(String bigger, String smaller, int i, int fi, int li, int counter ) {
		if(i<0) return -1;
		else if(li> bigger.length()) return -1;
		else if(bigger.substring(fi, li).equals(smaller)) {
			if(i==0) return fi;
			else if(i==counter) return fi;
			counter++;
		}
		
		return q1Helper(bigger,smaller,i,++fi,++li,counter);
	}
	///--------------------------------------------------------------------

	///------------------------------Q2------------------------------------

	/**
	 * Travel between lowerB and upperB and uses binarySerach if the value is in the array or not
	 * @param arr int array for searching
	 * @param lowerB lower Bound 
	 * @param upperB upper Bound
	 * @param count how many elements there are
	 * @return count of elementes between lowerB and upperB
	 */
	public int q2(int[] arr,int lowerB, int upperB,int count) {
    	
    	if(lowerB > upperB) return count;
    	else {
    		if(binarySearch(arr,0,arr.length-1,lowerB))
    			count++;
    		lowerB++;
    		return q2(arr,lowerB, upperB,count);
    	}
    }
	/**
	 * Just Binary Serach algorithm
	 * @param arr int array
	 * @param l left index
	 * @param r rigth index
	 * @param x value that will be searched
	 * @return true if x is in arr return false otherwise
	 */
    public boolean binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return true;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return false;
    }
    

   
	///--------------------------------------------------------------------
	
	///------------------------------Q3------------------------------------
	//example call: int[] arr = {5,3,8,1,2,11,0,7,5,6,8,4,12,13,15,17,20,2,0,11,10,1,0,1}; q3(arr,11);
    /**
	 * Just calls the q3Helper 
	 * 
	 * @param arr int 
	 * @param val sum
	 */
	public void q3(int[] arr, int val) {
		q3Helper(arr,val,0,0,0);
	}
	/**
	 * finds contiguous subarray/s that the sum of its/theirs items is equal to a given integer value and Prints it
	 * @param arr int are that will be searched on it 
	 * @param val the sum of sub arrays will be equal to this val
	 * @param sum sum of internal values
	 * @param fi first inidex
	 * @param li last index
	 */
	public void q3Helper(int[] arr, int val, int sum, int fi, int li) {
		
		if(fi>= arr.length) return;
		if(li>=arr.length) {
			return;
		}
		sum+=arr[li];
		if(sum==val) {
			print(arr,fi,li);
			li++;
			q3Helper(arr,val,sum,fi,li);			
		}
		else if(sum<val) {
			li++;
			q3Helper(arr,val,sum,fi,li);
		}
		else if(sum>val) {
			fi++;
			li=fi;
			sum=0;
			q3Helper(arr,val,sum,fi,li);			
		}	

	}
	/**
	 * Prints the given array between fi and li
	 * @param arr arr to be print
	 * @param fi first index	
	 * @param li last index
	 */
	public void print(int[] arr, int fi, int li) {
		if(fi>= arr.length || li>= arr.length) {
			
			System.out.println();
			return;
		}
		if(fi>li) {
			System.out.println();
			return;
		}
		System.out.print(arr[fi]+" ");
		print(arr,++fi,li);
	}
///--------------------------------------------------------------------
	/**
	 * Just uses the q5Helper(....) method
	 * @param arr char array 
	 * @param size start size
	 */
	public void q5(char[] arr, int size){
		Arrays.fill(arr, '.');
		q5Helper(arr,size,0,size-1);
	}
	/**
	 * The given array must will be traveled
	 * @param arr char array
	 * @param size start size.
	 * @param sp start point
	 * @param ep end point
	 */
	public void q5Helper(char[] arr, int size, int sp, int ep){

		if(ep==arr.length) {
			Arrays.fill(arr, '.'); //clear the array
			size++;
			System.out.println();
			
			if(size<=arr.length){

				q5Helper(arr,size,0,size-1);
			}
		}
		else{

			float rest = (float)(arr.length-ep-1)/size;
			/*arr[sp] = 'o';
			arr[ep] = 'o';*/
			arr = fillBetween(arr, sp, ep);
			if(rest>1){
				int nsp = ep+2;
				int nep = ep+size+1;
				//arr[nsp] = '#';
				//arr[nep] = '#';	
				arr = fillBetween(arr, nsp, nep);
			}
			print(arr);
			Arrays.fill(arr, '.');
			sp++;
			ep++;
			q5Helper(arr,size,sp,ep);
		}
	}
	/**
	 * Just a print function
	 * @param arr array to be print
	 */
	private void print(char[] arr){
		for(int i =0; i< arr.length; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	
	}
	/**
	 * Just fills between fi and li with 'o'
	 * @param arr char array to be partially filled
	 * @param fi first index 
	 * @param li last index
	 * @return new partially filled array
	 */
	private char[] fillBetween(char[] arr, int fi,int li){
		if(li>= arr.length || fi>=arr.length){
			System.out.print("error");
			return null;
		}
		for(int i=fi; i<=li; ++i){
			arr[i] = 'o';
		}
		return arr;
	}

	///--------------------------------------------------------------------
	
	
}


