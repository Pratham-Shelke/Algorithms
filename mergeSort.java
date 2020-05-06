import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class mergeSort
{

    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(new File("IntegerArray.txt"));
            ArrayList<Integer> l= new ArrayList<>();
            while (sc.hasNext())
            {
                if (sc.hasNextInt())
                {
                    l.add(sc.nextInt());
                }
                else
                    sc.next();
            }

            //Before Sorting
            printArrayList(l);

            sort(l,0,l.size()-1);

            //After Sorting
            printArrayList(l);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void sort(ArrayList<Integer> l, int min, int max)
    {
        if(min<max)
        {
            int mid=(min+max)/2;
            System.out.println("Reached");
            sort(l,min,mid);
            System.out.println("Reached1");
            sort(l,mid+1,max);
            System.out.println("Reached22");

            merge(l,min,mid,max);
        }
    }

    private static void printArrayList(ArrayList l)
    {

        for(Object i:l)
        {
            System.out.println(i);
        }

    }

    public static void merge(ArrayList<Integer> l, int min, int mid, int max)
    {
        //finding sizes of the sub arrays
        int s1=mid-min+1;
        int s2=max-mid;

        int[] L=new int[s1];
        int[] R=new int[s2];

        for(int i=0; i<s1; i++)
            L[i]= l.get(min+i);
        for(int i=0; i<s2; i++)
            R[i]= l.get(mid+i+1);

        int i=0,j=0;
        int k=min;

        //Comparing and copying the elements while merging the two halves

        while (i<s1 && j<s2)
        {
            if(L[i]<=R[j])
            {
                 l.set(k, L[i]);
                 i++;
            }
            else
            {
                l.set(k, R[j]);
                j++;
            }
            k++;
        }

        while (i<s1)
        {
            l.set(k, L[i]);
            i++;
            k++;
        }

        while (j<s2)
        {
            l.set(k, R[j]);
            j++;
            k++;
        }

    }
}
