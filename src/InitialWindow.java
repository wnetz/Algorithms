import Sorting.SortingAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialWindow extends JFrame
{
    private SortingAlgorithms sortingAlgorithms;
    private CardLayout cardLayout;
    public InitialWindow()
    {
        JPanel types = new JPanel();
        types.setBackground(Color.gray);
        types.setLayout(new FlowLayout());

        JPanel mainPage = new JPanel();

        cardLayout = new CardLayout();
        sortingAlgorithms = new SortingAlgorithms(cardLayout,mainPage);

        mainPage.setPreferredSize(new Dimension(500,500));
        mainPage.setLayout(cardLayout);
        mainPage.add("sorting",sortingAlgorithms);
        mainPage.add("types",types);
        cardLayout.show(mainPage, "types");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(new BorderLayout());
        add(mainPage,BorderLayout.CENTER);

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

        ImageIcon imageIcon = new ImageIcon("./src/logo.png");
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(imageIcon.getImage());


    }
}
