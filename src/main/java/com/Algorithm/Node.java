package com.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public Map<String, Node> nexts; 
    
    public String data;
    public int end;
    public Node() {
        this.nexts = new HashMap<String, Node>();
        this.end = 0;
        this.data=null;
    }
}
