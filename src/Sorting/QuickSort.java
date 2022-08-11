package Sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuickSort extends Sort
{
    private int depth;
    private boolean done;
    private ArrayList<Comparable> array;
    private ArrayList<Integer> index;
    private ArrayList<Integer> current;
    public QuickSort(ArrayList<Comparable> arr)
    {
        depth =  0;
        done = false;
        array = arr;
        index = new ArrayList<>();
        current = new ArrayList<>();
    }
    public void reset(ArrayList<Comparable> arr)
    {
        depth =  0;
        done = false;
        array = arr;
        index = new ArrayList<>();
        current = new ArrayList<>();
    }

    public void tick()
    {
        if(!isDone())
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            current = new ArrayList<>();
            if(index.size() == 0)
            {
                index.add(animatedSort(0, array.size() - 1));
                current.add(index.get(0));
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                index.forEach(i-> temp.add(i));
                index.add(0,animatedSort(0, index.get(0)-1));
                current.add(index.get(0));
                for(int i = 2; i < index.size();i+=2)
                {
                    index.add(i,animatedSort(index.get(i-1)+1, index.get(i))-1);
                    current.add(index.get(i));
                }
                index.add(animatedSort(index.get(index.size()-1)+1,array.size() - 1));
                current.add(index.get(index.size()-1));
                index = new ArrayList<>(index.stream().filter(a-> a>0).collect(Collectors.toList()));
                current = new ArrayList<>(current.stream().filter(a-> a>0).collect(Collectors.toList()));
                //index = temp;
            }
        }
    }
    public void render(Graphics g, int width, int height)
    {
        g.setColor(Color.WHITE);
        for (int i = 0; i < array.size(); i++)
        {
            g.fillRect(i * width/array.size(), (int)(height-(Double) array.get(i)*height), width/array.size(), (int)((Double) array.get(i)*height));
        }
        g.setColor(Color.RED);
        for(int i = 0; i < current.size(); i++)
        {
            g.fillRect(current.get(i) * width/array.size(), (int)(height-(Double) array.get(current.get(i))*height), width/array.size(), (int)((Double) array.get(current.get(i))*height));
        }
        current = new ArrayList<>();
    }
    @Override
    public boolean isDone()
    {
        int count = 0;
        for(int i = 1; i < array.size()-1;i++)
        {
            count = array.get(i).compareTo(array.get(i-1)) >= 0 ? count: count+1;
        }
        return count == 0;
    }
    private int animatedSort(int start, int end)
    {
        if(start < end && end < array.size())
        {
            Comparable pick = array.get(end);
            int swapIndex = start;
            for (int i = start; i < end; i++)
            {
                if (pick.compareTo(array.get(i)) >= 0)
                {
                    Comparable temp = array.get(i);
                    array.set(i, array.get(swapIndex));
                    array.set(swapIndex, temp);
                    swapIndex++;
                }
            }
            array.set(end, array.get(swapIndex));
            array.set(swapIndex, pick);
            return swapIndex;
        }
        return -1;
    }
    public ArrayList<Comparable> sort(ArrayList<Comparable> array)
    {
        return sort(array,0, array.size()-1);
    }
    private ArrayList<Comparable> sort(ArrayList<Comparable> array, int start, int end)
    {
        if(start < end && end < array.size())
        {
            Comparable pick = array.get(end);
            int swapindex = start;
            for (int i = start; i < end; i++)
            {
                if (pick.compareTo(array.get(i)) >= 0)
                {
                    Comparable temp = array.get(i);
                    array.set(i, array.get(swapindex));
                    array.set(swapindex, temp);
                    swapindex++;
                }
            }
            array.set(end, array.get(swapindex));
            array.set(swapindex, pick);
            sort(array, 0, swapindex - 1);
            sort(array, swapindex + 1, end);
        }
        return array;
    }
}
