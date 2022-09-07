package co.com.epam.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("---Evaluating Parallel Implementation...---");

        int[] parallelArray = new int[]{5, 2, 9, 7, 3};
        ParallelSorter parallelSorter = new ParallelSorter(parallelArray);
        logger.info("Initial array {}", parallelSorter.getArray());
        parallelSorter.sort();
        logger.info("After Sorting: {}", parallelSorter.getArray());

        logger.info("---Evaluating QuickSort Implementation...---");

        int[] quickSortArray = new int[]{5, 3, 9, 7, 4, -1, 2, 10};
        ParallelSorter quickSorter = new ParallelSorter(quickSortArray);
        logger.info("Initial array {}", quickSorter.getArray());
        quickSorter.quickSort();
        logger.info("After Sorting: {}", quickSorter.getArray());
    }
}
