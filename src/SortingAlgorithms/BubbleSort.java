package SortingAlgorithms;

import Visualizer.SortBars;

public class BubbleSort implements SortingInterface {

    @Override
    public String getName() {
        return "BUBBLE SORT";
    }

    @Override
    public long getDelay() {
        return 2;
    }

    @Override
    public void runSort(SortBars bars) {
        int length = bars.arraySize();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (bars.getValue(j) > bars.getValue(j + 1)) {
                    bars.swap(j, j + 1, 2);
                }
            }
        }
    }
}
