package com.hackathon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.primitives.Ints;

/*Design a program to find triplet counts present in an array 
 * where more than one index of the array can't be consecutive and
 * the product of elements of every triplet must satisfy the desired capacity.
 * Eg:
Given array contains arr=[1, 4, 2, 5]
Expected capacity=10

Possible combinations would be:
[[1, 4, 2], [1, 4, 5], [1, 2, 5], [4, 2, 5]]

Possible triplets indexes from the given capacity(Array)
[[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]]

Triplet satisfies adjacency rule: [[0, 1, 3], [0, 2, 3]]

Triplet Qualified Indexes set:
[0, 2, 3]
Triplet Qualified Indexes value:
[[1 2 5 ]]
Total number of triplets present in the list satisfying desired capacity:1 
 */

public class Triplet {
	List<ArrayList<Integer>> executedList = new ArrayList<ArrayList<Integer>>();
	List<ArrayList<Integer>> listTripletQualified = new ArrayList<ArrayList<Integer>>();
	static List<ArrayList<Integer>> listPossibleCombinations = new ArrayList<ArrayList<Integer>>();
	int r = 3;

	public static void main(String args[]) {
		Triplet obj = new Triplet();
		ArrayList<Integer> capacity = new ArrayList<>(List.of(1, 4, 2, 5));
		System.out.println(capacity);
		int desiredCpacity = 10;
		long tripletCount = obj.totalTriplets(capacity, desiredCpacity);
		System.out.println("\nTotal number of triplets present in the list satifying desired capacity:" + desiredCpacity
				+ "=" + tripletCount);
	}

	public long totalTriplets(List<Integer> capacity, long desiredCapacity) {
		
		int data[] = new int[r];
		combination(Ints.toArray(capacity), data, 0, capacity.size() - 1, 0, r);
		System.out.println(listPossibleCombinations);
		listPossibleCombinations.clear();
		combination(IntStream.range(0, capacity.size()).toArray(), data, 0, capacity.size() - 1, 0, r);
		System.out.println("\nPossible triplest indexes from given capacity\n" + listPossibleCombinations);
		Triplet obj = new Triplet();
		long tripletCount = 0;
		boolean statsuDesiredCapacity = false;

		for (ArrayList<Integer> list : listPossibleCombinations) {
			boolean adjacent = obj.checkAdjacency(list, r);
			if (adjacent) {
				executedList.add(list);
				statsuDesiredCapacity = obj.verifyDesiredCapacity(list, capacity, desiredCapacity);
				if (statsuDesiredCapacity) {
					listTripletQualified.add(list);
					tripletCount++;
				}
			}

		}
		System.out.println("\nTriplet satisfies adjacency rule" + executedList);
		tripletQualified(listTripletQualified, capacity);
		return tripletCount;
	}

	private void tripletQualified(List<ArrayList<Integer>> listTripletQualified, List<Integer> capacity) {
		System.out.println("\nTriplet Qulifed Indexes set:");
		for (ArrayList<Integer> triplet : listTripletQualified) {
			System.out.print(triplet);
		}
		System.out.println("\nTriplet Qulifed Indexes value:");
		System.out.print("[");
		for (ArrayList<Integer> triplet : listTripletQualified) {
			System.out.print("[");
			for (int index : triplet) {
				System.out.print(capacity.get(index) + " ");
			}
			System.out.print("]");
		}
		System.out.print("]");

	}

	private boolean verifyDesiredCapacity(List<Integer> aTripletOfIndexes, List<Integer> capacity,
			long desiredCapacity) {
		long res = 1;
		boolean status = false;
		for (int index : aTripletOfIndexes) {
			res = res * capacity.get(index);
		}
		if (res == desiredCapacity) {
			status = true;
		}
		return status;
	}

	boolean checkAdjacency(List<Integer> aTriplet, int r) {
		boolean status = false;
		int baseIndex, nextIndex;
		int index = 0;
		int adjacenyCount = 0;
		while (index < r - 1) {
			baseIndex = aTriplet.get(index);
			nextIndex = aTriplet.get(index + 1);
			if (Math.abs(baseIndex - nextIndex) == 1) {
				adjacenyCount++;
			}
			index++;
		}
		if (adjacenyCount == 1) {
			status = true;
		}
		return status;
	}

	public void combination(int[] ks, int data[], int start, int end, int index, int r) {
		ArrayList<Integer> list = null;
		if (index == r) {
			list = new ArrayList<Integer>();
			for (int j = 0; j < r; j++) {
				list.add(data[j]);
			}
			listPossibleCombinations.add(list);
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = (int) ks[i];
			combination(ks, data, i + 1, end, index + 1, r);
		}
	}
}
