package com.shc.learning.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.insert(new TreeNode(50));
		tree.insert(new TreeNode(0));
		tree.insert(new TreeNode(40));
		tree.insert(new TreeNode(30));
		tree.insert(new TreeNode(1));
		tree.insert(new TreeNode(150));
		tree.insert(new TreeNode(80));
		tree.insert(new TreeNode(20));
		tree.insert(new TreeNode(90));
		
		System.out.println(tree);
	}
}
