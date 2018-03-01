package com.sunyang.btree;

public class TestBTree {

	public static void main(String[] args) {
		BTree tree = new BTree();
		tree.insert(6, 6);
		tree.insert(3, 3); 
		tree.insert(14, 14); 
		tree.insert(16, 16); 
		tree.insert(10, 10); 
		tree.insert(9, 9); 
		tree.insert(13, 13); 
		tree.insert(11, 11); 
		tree.insert(12, 12); 
		tree.middleTraversal(tree.root);//ÖĞĞò±éÀú²Ù×÷ 
	}
}
