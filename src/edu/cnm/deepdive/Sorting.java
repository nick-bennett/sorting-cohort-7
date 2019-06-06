package edu.cnm.deepdive;

import java.util.Arrays;

public class Sorting {

  public static void sort(int[] data) {
    if (data.length <= 1) {
      return;
    }
    int leftSize = data.length / 2;
    int rightSize = data.length - leftSize;
    int[] left;
    int[] right;
    left = Arrays.copyOf(data, leftSize);
    right = Arrays.copyOfRange(data, leftSize, data.length);
    sort(left);
    sort(right);
    int leftIndex = 0;
    int rightIndex = 0;
    int mergeIndex = 0;
    while (leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex] < right[rightIndex]) {
        data[mergeIndex] = left[leftIndex];
        leftIndex++;
      } else {
        data[mergeIndex] = right[rightIndex];
        rightIndex++;
      }
      mergeIndex++;
    }
    if (leftIndex < left.length) {
      System.arraycopy(left, leftIndex, data, mergeIndex, data.length - mergeIndex);
    } else {
      System.arraycopy(right, rightIndex, data, mergeIndex, data.length - mergeIndex);
    }
  }

}
