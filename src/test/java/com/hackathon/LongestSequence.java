package com.hackathon;

import java.util.ArrayList;
import java.util.List;


/* This program used to find the longest list of 1s and 0s. It will display
 * the max length of consequtive and 1s and 0s
 */
public class LongestSequence {
	public void displayLongestSequence(int a[]) {
		int previousValue = a[0];
		int current;
		List<Integer> zerosList = new ArrayList<Integer>();
		List<Integer> onesList = new ArrayList<Integer>();
		int maxZerosListSize = 0;
		int maxOnesListSize = 0;
		for (int i = 0; i < a.length; i++) {
			current = a[i];
			if (current != previousValue) {
				if (previousValue == 0) {
					if (zerosList.size() > maxZerosListSize) {
						maxZerosListSize = zerosList.size();
						zerosList.clear();
					}
				} else if (previousValue == 1) {
					if (onesList.size() > maxOnesListSize) {
						maxOnesListSize = onesList.size();
						onesList.clear();
					}

				}

				if (current == 0) {
					zerosList.add(current);
				}
				if (current == 1) {
					onesList.add(current);
				}
				previousValue = current;
			} else {
				if (current == 0) {
					zerosList.add(current);
				}
				if (current == 1) {
					onesList.add(current);
				}
				previousValue = current;
			}
		}
		if (zerosList.size() > maxZerosListSize) {
			maxZerosListSize = zerosList.size();
		}
		if (onesList.size() > maxOnesListSize) {
			maxOnesListSize = onesList.size();
		}
		System.out.println("Logest sequence of Ones=" + maxOnesListSize);
		System.out.println("Logest sequence of Zeros=" + maxZerosListSize);

	}

	public static void main(String args[]) {
		int arr[] = { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1,1,1,1,1,1,1,0,0 };
		LongestSequence seq = new LongestSequence();
		seq.displayLongestSequence(arr);
	}
}
