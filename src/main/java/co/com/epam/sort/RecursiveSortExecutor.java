package co.com.epam.sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class RecursiveSortExecutor extends RecursiveAction {

    private final int start;
    private final int end;
    private final int[] input;

    public RecursiveSortExecutor(int[] input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (start < end) {
            int mid = (end + start) / 2;
            RecursiveSortExecutor left = new RecursiveSortExecutor(input, start, mid);
            RecursiveSortExecutor right = new RecursiveSortExecutor(input, mid + 1, end);
            invokeAll(left, right);
            merge(start, mid, end);
        }
    }

    private void merge(int left, int mid, int right) {

        int[] leftTempArray = Arrays.copyOfRange(input, left, mid + 1);
        int[] rightTempArray = Arrays.copyOfRange(input, mid + 1, right + 1);

        int leftTempIndex = 0;
        int rightTempIndex = 0;
        int mergeIndex = left;

        while (leftTempIndex < leftTempArray.length) {
            if (leftTempIndex < mid - left + 1 && rightTempIndex < right - mid) {
                if (leftTempArray[leftTempIndex] <= rightTempArray[rightTempIndex]) {
                    input[mergeIndex] = leftTempArray[leftTempIndex];
                    leftTempIndex++;
                } else {
                    input[mergeIndex] = rightTempArray[rightTempIndex];
                    rightTempIndex++;
                }
            } else if (leftTempIndex < mid - left + 1) {
                input[mergeIndex] = leftTempArray[leftTempIndex];
                leftTempIndex++;
            } else if (rightTempIndex < right - mid) {
                input[mergeIndex] = rightTempArray[rightTempIndex];
                rightTempIndex++;
            }
            mergeIndex++;
        }
    }
}
