package com.hackathon;

import java.util.ArrayList;
import java.util.List;

/*
 An array has n elements. If the array has less than 2 elements, 
 then the array is returned without any changes. 
 If the array has more than two elements, then it is divided into two arrays, left and right. 
 The left array contains the first half elements of the input array 
 while the right array contains the second half of the elements. 
 If n is odd, the left array takes the middle element. Next, 
 the algorithm calls itself first with the left array and
 then with the right array. After that, the algorithm produces the sorted array,
 by merging the left and the right arrays into a single sorted array. 
 In this challenge, keep a count for each of the elements in the input array. 
 Initially, all counts are 0. Whenever an integer k from the right array is merged before 
 at least one element from the left array, add 1 to the count.
 Find the maximum count value after the merge sort algorithm finishes.

Example
arr = [2, 3, 1]
All counters are initialized to 0. First, the mergesort divides the input array into left = [2,3] and right = [1]. Next, it runs itself again with the left array. It divides this array into [2] and [3]. Since both are sorted, it merges them, and during the merge 3 is merged after 2 into the sorted order, so nothing is added to the counter. After the merge, the algorithm returns [2,3] to its caller. Next, the initial mergesort call runs itself for the right array [1] but since it has only one element no merging is performed and [1] is returned immediately. Next, the algorithm merges [2,3] with [1]. Since 1 from the right array comes before both elements from the left array during the merge, we add 1 to the counter. After this merge, the algorithm finishes, and the maximum count after the process is 1.Function Description 
Complete the function largestCountValue in the editor below. The function must return an integer that denotes the maximum count value after the entire merge sort algorithm finishes for the input array arr.
The function has the following parameter(s):
arr: integer array of size n with all unique elements   

Constraints
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 109
all elements of arr are distinct

Input Format Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.

In the first line, there is a single integer n.
Each of the following n lines contains an integer, arr[i].

Sample Case 0
Sample Input

STDIN     Function 
-----     -------- 
3     →   arr[] size n = 3
2     →   arr = [ 2, 1, 3]
1
3
 

Sample Output

1
 

Explanation

n = 3

arr = [2, 1, 3]

 

All counters are initialized to 0. First, the mergesort divides the input array into left = [2,1] and right = [3]. Next, it runs itself again with the left array. It divides this array into [2] and [1]. Since both of these are sorted, it starts merging them. The value 1 is merged before 2 into the sorted order, it is from the right array. No element from the left array has been inserted. Add 1 to the counter. After the merge, the algorithm returns [1,2] to its caller. Next, the initial mergesort call runs itself for the right array. Since it has only one element, no merging is performed and [3] is returned immediately. Next, the algorithm merges [1,2] with [3]. No elements from the right array come before any element from the left array during the merge, so no counts are incremented and the sorted array is returned after the merge. The maximum count after the process is 1.

 

Sample Case 1
Sample Input

STDIN     Function
-----     --------
6     →   arr[] size n = 6
1     →   arr = [1, 2, 3, 4, 5, 10]
2
3
4
5
10
 

Sample Output

0
 

Explanation

n = 6

arr = [1, 2, 3, 4, 5, 10]

 

The first step, break the array into left = [1, 2, 3] and right = [4, 5, 10]. Now break left into left' = [1, 2] and right' = [3]. Break left' into left" = [1] and right" = [2].  Perform the merge to get res" = [1, 2]. The element from right" was not inserted before an element of left", so the count remains 0. Merge res" and right' to get res' = [1, 2, 3]. Again, no element of right' was inserted before an element of res", so the count remains 0. The array right uses the same logic to arrive at a count of 0. Finally, merging [1, 2, 3] and [4, 5, 10], no element from the right array is inserted before any element of the left array has been inserted, so the count remains 0. 
 */
public class MergesortInsertionRightToLeft {
	static int totalCount = 0;
	/* Java program for Merge Sort */

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
				totalCount++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int largesteCountValue(List<Integer> a) {
		int c;
		int arr[] = a.stream().mapToInt(i->i).toArray();
		printArray(arr);
		MergesortInsertionRightToLeft ob = new MergesortInsertionRightToLeft();
		ob.sort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		printArray(arr);
		c = totalCount;
		return c;
	}

	// Driver method
	public static void main(String args[]) {
		ArrayList<Integer> capacity = new ArrayList<>(List.of(2, 3, 1));
		int count = largesteCountValue(capacity);
		System.out.println("Total Number of right to left insertion:" + count);
	}
}
