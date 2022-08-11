import Display.DisplaySort;
import Sorting.SortingAlgorithms;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Algorithms");
        ImageIcon imageIcon = new ImageIcon("./src/logo.png");

        DisplaySort displaySort = new DisplaySort();
        SortingAlgorithms sortingAlgorithms;
        CardLayout cardLayout;

        JPanel types = new JPanel();
        types.setBackground(Color.gray);
        types.setLayout(new FlowLayout());

        JPanel mainPage = new JPanel();

        cardLayout = new CardLayout();
        sortingAlgorithms = new SortingAlgorithms(cardLayout,mainPage, displaySort);

        mainPage.setPreferredSize(new Dimension(500,500));
        mainPage.setLayout(cardLayout);
        mainPage.add(displaySort, "display");
        mainPage.add("sorting",sortingAlgorithms);
        mainPage.add("types",types);
        cardLayout.show(mainPage, "types");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setLayout(new BorderLayout());
        window.add(mainPage,BorderLayout.CENTER);

        JButton sortButton = new JButton("Sort");
        JButton searchButton = new JButton("Search");
        JButton graphButton = new JButton("Graph");
        JButton dynamicProgrammingButton = new JButton("Dynamic programming");
        JButton numberTheoryButton = new JButton("Number theory");
        JButton geometricButton = new JButton("Geometric");
        JButton dataStructuresButton = new JButton("Data Structures");

        sortButton.addActionListener(e-> {
            System.out.println("Sort");
            cardLayout.show(mainPage,"sorting");
        });
        searchButton.addActionListener(e-> System.out.println("Search"));
        graphButton.addActionListener(e-> System.out.println("Graph"));
        dynamicProgrammingButton.addActionListener(e-> System.out.println("Dynamic programming"));
        numberTheoryButton.addActionListener(e-> System.out.println("Number theory"));
        geometricButton.addActionListener(e-> System.out.println("Geometric"));
        dataStructuresButton.addActionListener(e-> System.out.println("Data Structures"));

        types.add(sortButton);
        types.add(searchButton);
        types.add(graphButton);
        types.add(dynamicProgrammingButton);
        types.add(numberTheoryButton);
        types.add(geometricButton);
        types.add(dataStructuresButton);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setIconImage(imageIcon.getImage());

        window.pack();
        window.setLocationRelativeTo(null);
        displaySort.start();
    }
}
