package SortingAlgorithms;

import Visualizer.SortBars;

import java.util.Random;

public class QuickSort implements SortingInterface {

    private void quickSort(SortBars bars, int lowIndex, int highIndex) {
        if (lowIndex < highIndex + 1) {
            int partition = partition(bars, lowIndex, highIndex);
            quickSort(bars, lowIndex, partition - 1);
            quickSort(bars, partition + 1, highIndex);
        }
    }

    private int getPivot(int lowIndex, int highIndex) {
        Random random = new Random();
        return random.nextInt(highIndex - lowIndex + 1) + lowIndex;
    }


    private int partition(SortBars bars, int lowIndex, int highIndex) {
        bars.swap(lowIndex, getPivot(lowIndex, highIndex), 10);
        int border = lowIndex + 1;

        for (int i = border; i <= highIndex; i++) {
            if (bars.getValue(i) < bars.getValue(lowIndex)) {
                bars.swap(i, border++, 10);
            }
        }

        bars.swap(lowIndex, border - 1, 10);
        return border - 1;


    }

    @Override
    public String getName() {
        return "QUICK SORT";
    }

    @Override
    public long getDelay() {
        return 2;
    }

    @Override
    public void runSort(SortBars bars) {
        quickSort(bars, 0, bars.arraySize() - 1);
    }
}
