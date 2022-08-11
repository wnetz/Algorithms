package Sorting;

import java.awt.*;
import java.util.ArrayList;

public abstract class Sort
{
    public abstract boolean isDone();
    public abstract void tick();
    public abstract void render(Graphics g, int width, int height);
    public abstract ArrayList<Comparable> sort(ArrayList<Comparable> arr);
}
