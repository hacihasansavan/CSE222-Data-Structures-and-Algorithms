

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Integer[] arr100 = new Integer[100];
		Integer[] arr1000 = new Integer[1000];
		Integer[] arr10000 = new Integer[10000];

		// for each iteration, time will be saved. at the end the mean will be
		// calculated
		Vector<Double> quickSortResult = new Vector<Double>();
		Vector<Double> mergeSortResult = new Vector<Double>();
		Vector<Double> newSortResult = new Vector<Double>();
		Random rd = new Random();
		double meanMergeSort = 0;
		double meanQuickSort = 0;
		double meanNewSort = 0;
		double sum = 0;
		// ----------------------------------------------------------------------
		// Small size: 100

		for (int i = 0; i < 1000; i++) {
			for (int k = 0; k < 100; k++) {
				arr100[k] = rd.nextInt();
			}

			double start = System.currentTimeMillis();
			QuickSort.sort(arr100);
			double time = System.currentTimeMillis() - start;
			quickSortResult.add(time);

			start = System.currentTimeMillis();
			MergeSort.sort(arr100);
			time = System.currentTimeMillis() - start;
			mergeSortResult.add(time);

			start = System.currentTimeMillis();
			newSort(arr100, 0, arr100.length - 1);
			time = System.currentTimeMillis() - start;
			newSortResult.add(time);
		}

		for (int i = 0; i < mergeSortResult.size(); ++i) {
			sum += mergeSortResult.get(i);
		}

		meanMergeSort = sum / mergeSortResult.size();
		sum = 0;
		for (int i = 0; i < quickSortResult.size(); ++i) {
			sum += quickSortResult.get(i);
		}

		meanQuickSort = sum / quickSortResult.size();

		sum = 0;
		for (int i = 0; i < newSortResult.size(); ++i) {
			sum += newSortResult.get(i);
		}

		meanNewSort = sum / newSortResult.size();
		System.out.println("100luk:");
		System.out.println("mean merge sort: " + meanMergeSort);
		System.out.println("mean quick sort: " + meanQuickSort);
		System.out.println("mean new sort: " + meanNewSort);
		System.out.println();
		// ----------------------------------------------------------------------

		// medium size: 1000
		for (int i = 0; i < 1000; i++) {
			for (int k = 0; k < 1000; k++) {
				arr1000[k] = rd.nextInt();
			}

			double start = System.currentTimeMillis();
			QuickSort.sort(arr1000);
			double time = System.currentTimeMillis() - start;
			quickSortResult.add(time);

			start = System.currentTimeMillis();
			MergeSort.sort(arr1000);
			time = System.currentTimeMillis() - start;
			mergeSortResult.add(time);

			start = System.currentTimeMillis();
			newSort(arr1000, 0, arr1000.length - 1);
			time = System.currentTimeMillis() - start;
			newSortResult.add(time);

		}
		meanMergeSort = 0;
		meanQuickSort = 0;
		sum = 0;
		for (int i = 0; i < mergeSortResult.size(); ++i) {
			sum += mergeSortResult.get(i);
		}

		meanMergeSort = sum / mergeSortResult.size();
		sum = 0;
		for (int i = 0; i < quickSortResult.size(); ++i) {
			sum += quickSortResult.get(i);
		}

		meanQuickSort = sum / quickSortResult.size();

		sum = 0;
		for (int i = 0; i < newSortResult.size(); ++i) {
			sum += newSortResult.get(i);
		}

		meanNewSort = sum / newSortResult.size();
		System.out.println("1000luk:");
		System.out.println("mean merge sort: " + meanMergeSort);
		System.out.println("mean quick sort: " + meanQuickSort);
		System.out.println("mean new sort: " + meanNewSort);
		System.out.println();

		// Big size: 10000

		for (int i = 0; i < 1000; i++) {
			for (int k = 0; k < 10000; k++) {
				arr10000[k] = rd.nextInt();
			}

			double start = System.currentTimeMillis();
			QuickSort.sort(arr10000);
			double time = System.currentTimeMillis() - start;
			quickSortResult.add(time);

			start = System.currentTimeMillis();
			MergeSort.sort(arr10000);
			time = System.currentTimeMillis() - start;
			mergeSortResult.add(time);

			start = System.currentTimeMillis();
			newSort(arr10000, 0, arr10000.length - 1);
			time = System.currentTimeMillis() - start;
			newSortResult.add(time);

		}
		meanMergeSort = 0;
		meanQuickSort = 0;
		sum = 0;
		for (int i = 0; i < mergeSortResult.size(); ++i) {
			sum += mergeSortResult.get(i);
		}

		meanMergeSort = sum / mergeSortResult.size();
		sum = 0;
		for (int i = 0; i < quickSortResult.size(); ++i) {
			sum += quickSortResult.get(i);
		}

		meanQuickSort = sum / quickSortResult.size();

		sum = 0;
		for (int i = 0; i < newSortResult.size(); ++i) {
			sum += newSortResult.get(i);
		}

		meanNewSort = sum / newSortResult.size();
		System.out.println("10000luk:");
		System.out.println("mean merge sort: " + meanMergeSort);
		System.out.println("mean quick sort: " + meanQuickSort);
		System.out.println("mean new sort: " + meanNewSort);
		System.out.println();

	
	}

	/**
	 * min: minimum value max: maximum value
	 */
	static class MinMaxDuals {

		int min;
		int max;
	}
	/**
	 * NewSort Algorithm that is given pdf
	 * @param arr  is a Integer array that contains numbers (sorted or unsorted)
	 * @param head head point initially zero
	 * @param tail tail point that is on the right side initially arr.length-1
	 * @return Integer array that is sorted
	 * */
	public static Integer[] newSort(Integer[] arr, int head, int tail) {
		if (head > tail)
			return arr;

		MinMaxDuals mm = new MinMaxDuals();
		mm = min_max_finder(arr, head, tail);

		swap(arr, head, mm.min);
		swap(arr, tail, mm.max);

		return newSort(arr, head + 1, tail - 1);

	}

	/**
	 * swaps two given integer in array
	 * 
	 * @param arr  is a Integer array that contains numbers
	 * @param head head point (on the left)
	 * @param tail tail point that is on the right side
	 */
	static void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * finds min and max value pairs
	 * 
	 * @param arr  is a Integer array that contains numbers
	 * @param head head point (on the left)
	 * @param tail tail point that is on the right side
	 * @return MinMaxDuals class object that contains min and max values
	 */
	public static MinMaxDuals min_max_finder(Integer[] arr, int head, int tail) {
		MinMaxDuals m_m = new MinMaxDuals();
		min_max_finder_helper(arr, head, tail, m_m);
		return m_m;
	}

	/**
	 * helper function for min_max_finder function. This function does actual work
	 * that is finding min and max
	 * 
	 * @param arr  is a Integer array that contains numbers
	 * @param head head point (on the left)
	 * @param tail tail point that is on the right side
	 * 
	 */
	public static void min_max_finder_helper(Integer[] nums, int head, int tail, MinMaxDuals p) {
		// if the array contains only one element
		if (head == tail) {
			if (nums[p.max] < nums[head])
				p.max = head;
			if (nums[p.min] > nums[tail])
				p.min = tail;
			return;
		}
		// if the array contains only two elements
		if (tail - head == 1) {
			if (nums[head] < nums[tail]) {
				if (nums[p.min] > nums[head])
					p.min = head;

				if (nums[p.max] < nums[tail])
					p.max = tail;
			} else {
				if (nums[p.min] > nums[tail])
					p.min = tail;

				if (nums[p.max] < nums[head])
					p.max = head;
			}
			return;
		}
		//middle element
		int mid = (head + tail) / 2;
		//left subarray
		min_max_finder_helper(nums, head, mid - 1, p);
		//right subarray
		min_max_finder_helper(nums, mid, tail, p);
	}

}
