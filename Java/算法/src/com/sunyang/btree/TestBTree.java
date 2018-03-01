package com.sunyang.btree;

public class TestBTree {

	public static void main(String[] args) {
		
		/*
		 * 				6
		 * 			*		*
		 * 		3				14
		 * 					*		*	
		 * 				 10			 16
		 * 			   *	* 
		 * 			9 		  13
		 * 					 * 
		 * 					11
		 * 					  *
		 * 						12
		 * 
		 * 
		 * */
		
		BTree tree = new BTree();
		tree.insert(6, 6);
		tree.insert(3, 3);
		tree.insert(14, 14);
		tree.insert(16, 16);
		tree.insert(10, 10);
		tree.insert(13, 13);
		tree.insert(9, 9);
		tree.insert(11, 11);
		tree.insert(12, 12);
		Node n = tree.get(14);
		tree.preTraversal(tree.root);
		System.out.println("-----------");
		tree.middleTraversal(tree.root);//中序遍历操作 
		System.out.println("-----------");
		tree.postTraversal(tree.root);
		System.out.println("删除~~~~");
		tree.delete(10);//删除操作
		tree.middleTraversal(tree.root);//中序遍历操作 
	}
}
 