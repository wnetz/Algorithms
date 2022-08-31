package Display;

import Sorting.MergeSort;
import Sorting.QuickSort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DisplaySort extends JPanel implements Runnable
{
    public final int COLUMNS = 20, ROWS = 20; //number of squares
    public final int SPRITE_SIZE = 16;
    public final int SCALE = 3;
    public final int TILE_SIZE = SPRITE_SIZE*SCALE;
    public final int SCREEN_WIDTH = COLUMNS*TILE_SIZE, SCREEN_HEIGHT = ROWS*TILE_SIZE;
    private boolean running = false;
    private Thread gameThread;
    private Random rand;

    private ArrayList<Comparable> array = null;
    private ArrayList<ArrayList<Comparable>> working = null;
    private MergeSort mergeSort;
    private QuickSort quickSort;
    private int type;
    public DisplaySort()
    {
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        //mergeSort = new MergeSort();
        quickSort = new QuickSort(array);
        type = 0;
        rand = new Random();
    }
    public void setType(int t)
    {
        type = t;
        switch (type)
        {
            case 1: break;
            case 2: quickSort.reset(array);
        }
        array = null;
    }
    public synchronized void start()//start game
    {
        System.out.println("start");
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }
    public synchronized void stop()//end game
    {
        try
        {
            gameThread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        gameThread = new Thread();
        gameThread.start();
    }
    public void run()//start game loop
    {
        System.out.println("run");

        long lastTime = System.nanoTime();
        double ticksPerSecond = 60.0; // ticks per second
        double interval = 1000000000 /  ticksPerSecond;
        double delta = 0.0;

        while(running)
        {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;//number of ticks due since last loop
            lastTime = currentTime;
            tick();
            if(running)
            {
                repaint();//render game
            }
        }
        stop();
    }
    private void tick()
    {
        if(array == null)
        {
            array = new ArrayList<>();
            for(int i = 0; i < getWidth(); i+=1)
            {
                array.add(rand.nextDouble());
            }
            quickSort.tick(array);
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(array != null)
        {
             quickSort.render(g, getWidth(), getHeight());
        }
        /*if(working != null)
        {
            for (int i = 0; i < working.size(); i++)
            {
                for (int j = 0; j < working.get(i).size(); j++)
                {
                    if (j < (int)Math.ceil(working.get(i).size()/2.0))
                    {
                        g.setColor(Color.blue);
                    }
                    else
                    {
                        g.setColor(Color.YELLOW);
                    }
                    g.fillRect(array.indexOf(working.get(i).get(j)) * getWidth() / array.size(), (int) (getHeight() - (Double) working.get(i).get(j) * getHeight()), getWidth() / array.size(), (int) ((Double) working.get(i).get(j) * getHeight()));
                }
                int min = array.indexOf(working.get(i).get(0));
                for(Comparable c : working.get(i))
                {
                    min = Math.min(min,array.indexOf(c));
                }
                for(int j = 0; j < working.get(i).size();j++)
                {
                    array.set(min+j,working.get(i).get(j));
                }
            }

            working = MergeSort.animatedSort();
        }*/

        g.dispose();
    }
}
