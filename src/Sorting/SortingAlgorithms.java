package Sorting;

import Display.DisplaySort;

import javax.swing.*;
import java.awt.*;

public class SortingAlgorithms extends JPanel
{
    public SortingAlgorithms(CardLayout cardLayout, JPanel mainPage, DisplaySort displaySort)
    {
        JButton back = new JButton("Back");
        back.addActionListener(e->
        {
            System.out.println("Back");
            cardLayout.show(mainPage, "types");
        });
        JButton mergeSortButton = new JButton("Merge sort");
        mergeSortButton.addActionListener(e-> {
            System.out.println("Merge sort");
        });
        JButton quickSortButton = new JButton("quick sort");
        quickSortButton.addActionListener(e->
        {
            System.out.println("quick sort");
            cardLayout.show(mainPage, "display");
            displaySort.setType(2);
        });

        setLayout(new FlowLayout());
        add(back);
        add(mergeSortButton);
        add(quickSortButton);
        setBackground(Color.red);

        setVisible(false);
        setOpaque(true);
    }
}
