package com.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class nod {
    nod[] children;
    public int end;
    public int sonum=0;
    public nod() {
        end = 0;
        children = new nod[26];
    }
}
public class Trie_array {
    public nod root=new nod();



    public void insert(String word) {
        nod nod = root;
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(nod.children[ch] == null){
                nod.children[ch] = new nod();
                nod.sonum++;
            }
            nod = nod.children[ch];
        }
        nod.end = 1;
    }


    public int search(String word) {
        nod nod = root;
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(nod.children[ch] == null){
                return 0;
            }
            nod = nod.children[ch];
        }
        return nod.end;
    }

    List<String> list = new ArrayList<String>();
    public boolean startWith(String prefix) {
        nod nod = root;
        for(int i = 0; i < prefix.length(); i++){
            int ch = prefix.charAt(i) - 'a';
            if(nod.children[ch] == null)
                return false;
            nod = nod.children[ch];
        }
        return true;
    }
    public List<String> getData(String preword) {
        list.clear();
        if (!startWith(preword))
            return null;
        else {
            StringBuilder str = new StringBuilder("");
            str.append(preword);
            nod nod = root;
            for (int i = 0; i < preword.length(); i++){
                int ch = preword.charAt(i) - 'a';
                nod = nod.children[ch];
            }
            dfs(nod, str);
        }
        return list;
    }

    private void dfs(nod root, StringBuilder str) {
        if (root.end == 1) {
            list.add(str.toString());
            if (root.sonum==0)
                return;
        }
        nod nod = root;

        for(int i = 0; i < 26; i++){
            if(nod.children[i] != null){
                str.append(i+'a');
                dfs(nod.children[i], str);
                str.delete(str.length() - 1, str.length());
            }


        }

    }
}
