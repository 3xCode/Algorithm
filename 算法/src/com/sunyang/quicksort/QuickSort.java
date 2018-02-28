package com.sunyang.quicksort;

public class QuickSort {

	public static void main(String[] args) {

		int a[] = { 5, 2, 13, 4, 8};
		sort(a, 0, a.length - 1);
	}

	public static int quickSort(int[] a, int start, int end) {

		int middle = a[start];

		while (start < end) {

			while (a[end] >= middle && start < end) {
				--end;
			}
			a[start] = a[end];

			while (a[start] <= middle && start < end) {
				++start;
			}

			a[end] = a[start];
			a[start] = middle;
		}
		for (int i : a) {
			System.out.print(i + " ");
		}

		System.out.println();
		return end;
	}

	public static void sort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int index = quickSort(a, start, end);
		sort(a, start, index - 1);
		sort(a, index + 1, end);
	}

}
