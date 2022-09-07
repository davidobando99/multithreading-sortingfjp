package co.com.epam.sort;

import java.util.concurrent.ForkJoinPool;

public class ParallelSorter {

    private final int[] array;

    public ParallelSorter(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void sort() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new RecursiveSortExecutor(
                array, 0, array.length - 1));
        pool.shutdown();
    }

    public void quickSort() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new QuickSortExecutor(
                array, 0, array.length - 1));
        pool.shutdown();
    }
}
