package Visualizer;

import javax.swing.*;

import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SortingInterface;
import util.Sleep.*;

import java.awt.*;
import java.util.ArrayList;

import static util.Sleep.secondsToNano;
import static util.Sleep.sleepFor;

public class SortingVisualizer {

    private final JFrame window;
    private final SortBars bars;
    private final ArrayList<SortingInterface> SortQueue;

    public SortingVisualizer() {
        window = new JFrame("Sort Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bars = new SortBars();
        window.add(bars);
        window.pack();
        window.setVisible(true);

        SortQueue = new ArrayList<>();
        SortQueue.add(new BubbleSort());
        SortQueue.add(new MergeSort());
        SortQueue.add(new QuickSort());
    }

    private void ShuffleWaiter() {
        bars.shuffle();
        bars.resetColors();
        sleepFor(secondsToNano(2));
    }

    public void run() {
        for (SortingInterface algorithm : SortQueue) {
            sleepFor(secondsToNano(1));
            ShuffleWaiter();
            algorithm.runSort(bars);
            bars.resetColors();
            bars.highlightArray();
            sleepFor(5);
            JOptionPane.showMessageDialog(null, algorithm.getName() + " IS DONE");
            bars.resetColors();

        }
    }

    public static void main(String[] args) {
        SortingVisualizer visualizer = new SortingVisualizer();
        visualizer.run();
    }
}
