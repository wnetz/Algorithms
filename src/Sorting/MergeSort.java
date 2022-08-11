package Sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort extends Sort
{
    private static ArrayList<Comparable> array;
    public MergeSort(ArrayList<Comparable> arr)
    {
        array = arr;
    }
    public static void reset(ArrayList<Comparable> arr)
    {
        array = arr;
    }
    @Override
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

        }
    }

    @Override
    public void render(Graphics g, int width, int height)
    {
        g.setColor(Color.WHITE);
        for (int i = 0; i < array.size(); i++)
        {
            g.fillRect(i * width/array.size(), (int)(height-(Double) array.get(i)*height), width/array.size(), (int)((Double) array.get(i)*height));
        }
    }
    public static ArrayList<ArrayList<Comparable>> animatedSort()
    {
        ArrayList<ArrayList<Comparable>> ans = new ArrayList<>();
        if(array.size() <= 1)
        {
            ans.add(array);
        }
        else
        {
            ArrayList<ArrayList<Comparable>> temp = new ArrayList<>();
            temp.add(array);
            boolean done = false;
            do
            {
                done = true;
                for(int i = 0; i < temp.size(); i++)
                {
                    if(temp.get(i).size()>depth)
                    {
                        done = false;
                        ArrayList<Comparable> current = temp.get(i);
                        temp.remove(i);
                        int size = (int)Math.ceil(current.size()/2.0);
                        temp.add(new ArrayList<>(current.subList(0,size)));
                        temp.add(new ArrayList<>(current.subList(size,current.size())));
                    }
                }

            }
            while(!done);
            for(int i = 0; i < temp.size(); i++)
            {
                ans.add(sort(temp.get(i)));
            }
        }
        return ans;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    public ArrayList<Comparable> sort(ArrayList<Comparable> arr)
    {
        ArrayList<Comparable> ans = new ArrayList<>();
        if(arr.size() <= 1)
        {
            ans = arr;
        }
        else
        {
            int size = (int)Math.ceil(arr.size()/2.0);
            ArrayList<Comparable> subArray1 = sort(new ArrayList<>(arr.subList(0,size)));
            ArrayList<Comparable> subArray2 = sort(new ArrayList<>(arr.subList(size,arr.size())));
            while (subArray1.size() > 0 || subArray2.size() > 0)
            {
                Comparable a = subArray1.size() > 0 ? subArray1.get(0) : null;
                Comparable b = subArray2.size() > 0 ? subArray2.get(0) : null;
                if(b == null && a != null)
                {
                    subArray1.remove(a);
                    ans.add(a);
                }
                else if (b != null && a == null)
                {
                    subArray2.remove(b);
                    ans.add(b);
                }
                else if(a.compareTo(b) < 0)
                {
                    subArray1.remove(a);
                    ans.add(a);
                }
                else
                {
                    subArray2.remove(b);
                    ans.add(b);
                }
            }
        }
        return ans;
    }
}
