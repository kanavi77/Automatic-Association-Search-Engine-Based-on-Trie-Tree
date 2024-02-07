package com.Algorithm;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class qsort {
    public static void Sort(List<String> a, int left, int right, HashMap<String,Integer> b) {
        
        if (left > right) {
            return;
        }
        
        int i = left;
        
        int j = right;
        
        int  base = b.get(a.get(left));
        
        while (i != j) {
            
            while (b.get(a.get(j)) >= base && i < j) {
                j--;
            }
            
            while (b.get(a.get(i))<= base && i < j) {
                i++;
            }
            
            Collections.swap(a, i, j);
        }
        
        Collections.swap(a, i, left);

        Sort( a, left, i - 1,b);

        Sort(a, i + 1, right,b);
    }
}
