package Sorting;

import java.util.ArrayList;

public class QuickSort
{
    private static  ArrayList<Comparable> array;
    private static  int depth;
    public static void setUp()
    {
        depth = 0;
    }
    public static ArrayList<Comparable> animatedSort(ArrayList<Comparable> arr, int start, int end)
    {
        array = arr;
        try
        {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
            if(depth > 0)
            {
                animatedSort(array, start, swapindex - 1,depth-1);
                animatedSort(array, swapindex + 1, end,depth-1);
            }

        }
        depth++;
        return array;
    }
    public static ArrayList<Comparable> animatedSort(ArrayList<Comparable> arr, int start, int end, int d)
    {
        array = arr;
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
            if(d > 0)
            {
                animatedSort(array, start, swapindex - 1,d-1);
                animatedSort(array, swapindex + 1, end,d-1);
            }
        }
        return array;
    }
    public static ArrayList<Comparable> sort(ArrayList<Comparable> arr, int start, int end)
    {
        array = arr;
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
            sort(arr, 0, swapindex - 1);
            sort(arr, swapindex + 1, end);
        }
        return arr;
    }
}
