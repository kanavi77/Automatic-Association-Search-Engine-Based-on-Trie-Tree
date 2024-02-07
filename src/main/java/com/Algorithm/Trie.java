package com.Algorithm;

import java.util.*;
public class Trie {
	Node root = new Node();
	public Node getRoot(){
		return root;
	}
	public HashMap<String,Integer> map;
	public void SetMap(HashMap<String,Integer> a){
		map=a;
	}


	public void insert(String word) {
		if(word.isEmpty())return;

		Node node = root;
		char[] chr=word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			String str = String.valueOf(chr[i]);
			if (node.nexts.get(str) == null)
				node.nexts.put(str, new Node());
			node = node.nexts.get(str);
			node.data=str;
		}
		node.end = 1;
	}

	public boolean startWith(String preWord) {
		Node node = root;
		char[] chr=preWord.toCharArray();
		for (int i = 0; i < preWord.length(); i++) {
			String str = String.valueOf(chr[i]);
			if (node.nexts.get(str) == null)
				return false;
			node = node.nexts.get(str);
		}
		return true;
	}

	List<String> list = new ArrayList<String>();

	public List<String> getData(String preword) {
		list.clear();
		StringBuilder str = new StringBuilder("");
		str.append(preword);
		Node node = root;
		char[] chr=preword.toCharArray();
		if (startWith(preword)){
			for (int i = 0; i < preword.length(); i++)
				node = node.nexts.get(String.valueOf(chr[i]));
			dfs(node, str);
		}
		else return null;
		return list;
	}

	private void dfs(Node root, StringBuilder str) {
		String now=str.toString();
		Node node = root;
		if (root.end == 1) {
			list.add(now);
			if (root.nexts.isEmpty())
				return;
		}
		for (String s : node.nexts.keySet()) {
			str.append(s);
			dfs(node.nexts.get(s), str);
			str.delete(str.length() - 1, str.length());
		}
	}
	public boolean delete(String preWord){
		if(!startWith(preWord)){
			return false;
		}
		Stack<Node> st = new Stack<Node>();
		Node node = root;
		st.push(node);
		char[] chr=preWord.toCharArray();
		for (int i = 0; i < preWord.length()-1; i++) {
			String str = String.valueOf(chr[i]);
			node = node.nexts.get(str);
			st.push(node);
		}

		for(int i=preWord.length()-1;i>=0;i--){
			String str = String.valueOf(chr[i]);
			Node x=st.pop();
			if(x.end==1&&i!=preWord.length())
				break;
			if(x.nexts.get(str).nexts.isEmpty()){
				x.nexts.remove(str);
			}
			else{
				x.nexts.get(str).end=0;
			}
		}
		return true;
	}


}


