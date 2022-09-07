package co.com.epam.sort;

import java.util.concurrent.RecursiveAction;

public class QuickSortExecutor extends RecursiveAction {

    private final int start;
    private final int end;
    private final int[] input;

    public QuickSortExecutor(int[] input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (start < end) {
            int pivotIndex = partition(input, start, end);
            QuickSortExecutor t1 = new QuickSortExecutor(input, start,
                    pivotIndex - 1);
            QuickSortExecutor t2 = new QuickSortExecutor(input, pivotIndex + 1,
                    end);
            t1.fork();
            t2.compute();
            t1.join();
        }
    }

    int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        i++;
        swap(input, i, end);
        return i;
    }

    void swap(int[] input, int pivot, int end) {
        int t = input[pivot];
        input[pivot] = input[end];
        input[end] = t;
    }
}
