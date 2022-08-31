package Sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuickSort
{
    private ArrayList<Comparable> array;
    private ArrayList<Integer> state;
    private Thread thread;
    private boolean stop;
    public QuickSort(ArrayList<Comparable> arr)
    {
        array = arr;
        state = new ArrayList<>();
        stop = false;
        for(int i = 0; array!= null && i < array.size();i++)
        {
            state.add(-1);
        }
    }
    public void reset(ArrayList<Comparable> arr)
    {
        array = arr;
        state = new ArrayList<>();
        stop = false;
        for(int i = 0; i < array.size();i++)
        {
            state.add(-1);
        }
    }
    public void tick(ArrayList<Comparable> arr)
    {
        if(thread!=null)
        {
            stop = true;
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        reset(arr);
        thread = new Thread(()->sort(0,array.size()-1));
        thread.start();
    }
    public void render(Graphics g, int width, int height)
    {
        for (int i = 0; i < array.size(); i++)
        {
            if(state.get(i) == 0)
            {
                g.setColor(Color.RED);
            }
            else if(state.get(i) == 1)
            {
                g.setColor(Color.BLUE);
            }
            else if(state.get(i) == 2)
            {
                g.setColor(Color.GREEN);
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillRect(i * width/array.size(), (int)(height-(Double) array.get(i)*height), width/array.size(), (int)((Double) array.get(i)*height));
        }
    }
    public void sort(int start, int end)
    {
        if(start>=end || stop)
        {
            return;
        }
        for (int i = start; i <= end && !stop; i++)
        {
            state.set(i,1);
        }
        Comparable pivot = array.get(end);
        int swapindex = start;
        state.set(swapindex,0);
        for (int i = start; i < end && !stop; i++)
        {
            if (pivot.compareTo(array.get(i)) >= 0)
            {
                swap(i,swapindex);
                state.set(swapindex,2);
                swapindex++;
                state.set(swapindex,0);
            }
            state.set(i,2);
        }
        state.set(swapindex,-1);
        swap(swapindex,end);
        for (int i = start; i <= end && !stop; i++)
        {
            if(state.get(i) != 0)
                state.set(i,-1);
        }
        int finalSwapindex = swapindex;
        Thread thread1 = new Thread(()->sort(start, finalSwapindex - 1));
        Thread thread2 = new Thread(()->sort(finalSwapindex + 1, end));
        if(!stop)
        {
            thread1.start();
            thread2.start();
            try
            {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
    private void swap(int index1, int index2)
    {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Comparable temp = array.get(index1);
        array.set(index1,array.get(index2));
        array.set(index2,temp);
    }
}
