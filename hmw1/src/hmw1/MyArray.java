package hmw1;

import java.util.Arrays;

/**
 * <h1>MyArray Class</h1>
 * Custom Array. That uses simple array inside
 * @author Haci Hasan Savan
 * @since 2022-03-03
 * */
public class MyArray <T> {
	
	private int size = 0;
	private T[] simpleArray;
	public static int capacity;
	@SuppressWarnings("unchecked")
	public MyArray() {
		size = 0;
		capacity = 10;
		simpleArray = (T[]) new Structure[10];
	}
	@SuppressWarnings("unchecked")
	public MyArray(int x) {
		size = 0;
		capacity = x;
		simpleArray = (T[]) new Structure[x];
	}
	/**
	 * @return returns size of MyArray*/
	public int Size() {
		return size;
	}
	/**
	 * @return returns capacity of MyArray*/
	public int getCapacity() {
		return simpleArray.length;
	}
	/**
	 * @param index index of MyArray
	 * @return returns MyArray's given index*/
	public T get(int index) {
		return simpleArray[index];
	}
	/**
	 * uses Add(T,index) function
	 * @param addThis a T object*/
	public void Add(T addThis) throws Exception {
		//findIndexForAdd(position, arr);
		try {
			this.Add(addThis,size);
		}
		catch(Exception s) {
			throw s;
		}
	}
	/**
	 * Adds given object to given index if it is valid
	 * @param entry T object
	 * @param index index*/
	public void Add(T entry,int index) throws Exception{
		// check bounds
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Exception: It's not a valid address\n");
		}
		// Make sure there is room
		if (size >= capacity) {
			Reallocate();
		}
		// shift data
		for (int i = size; i > index; i--) {
			simpleArray[i] = simpleArray[i-1];
		}
		// insert item
		simpleArray[index] = entry;
		size++;
		System.out.print("Added: ");
		System.out.println(entry.toString());
		
	}
	/**
	 * Removes object that is in the given index if it's valid
	 * @param index int index
	 * @return removed T object */
	public T remove(int index) throws Exception {
		if (index < 0 || index >= size) {
				throw new ArrayIndexOutOfBoundsException("EXCEPTION: Array Index is out of bound\n");
		}
		String s;
		if(simpleArray[index]==null)
			throw new NullPointerException("EXCEPTION: Index is null\n");
		
		T returnValue = simpleArray[index];
		for (int i = index + 1; i < size; i++) {
				simpleArray[i -1] = simpleArray[i];
			}
		
		size--;
		System.out.print("Removed: ");
		System.out.println(returnValue.toString());
		return returnValue;
	}
	/**
	 * Reallocates the array capacity*/
	public void Reallocate() {
		capacity *= 2;
		simpleArray = Arrays.copyOf(simpleArray, capacity);
		
	}

}
