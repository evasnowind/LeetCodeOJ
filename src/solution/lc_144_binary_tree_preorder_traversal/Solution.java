package solution.lc_144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /*
     * 分析：最下面被注释的代码是初始版本，能通过，但通过看discuss和网上的
     * 			算法，我发现自己写的这个版本实际上多了一步左孩子入栈的操作，
     * 			这使得程序做了一些无用功，实际上只需要保存右孩子，仅右孩子入栈即可,
     * 			具体实现如下（https://discuss.leetcode.com/topic/6493/accepted-iterative-solution-in-java-using-stack ）
     *
     * 其他思路：
    两个节点都入栈
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    return result;
}

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            node = node.left;
        } else {
            node = stack.pop();
        }
    }
    return result;
}

void PreOrderTraverse(BiTree T)//非递归先序遍历
{

    stack<BiTree> Stack;
    if(!T)
    {
        printf("空树！\n");
        return;
    }
    while(T || !Stack.empty())
    {
        while(T)
        {
            Stack.push(T);
            printf("%c",T->data);
            T=T->lchild;
        }
        T=Stack.top();
        Stack.pop();
             T=T->rchild;
    }
}
     *
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
                if (node == null && !stack.isEmpty()) {
                    node = stack.pop();
                }
            }
        }
        return res;
    }
	
	/*
public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(null == root) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		stack.push(root);
		while(!stack.isEmpty()){
			res.add(node.val);
			while(null != node.left){
				node = node.left;
				res.add(node.val);
				stack.push(node);
			}
			while(!stack.isEmpty() && stack.peek().right == null){
				stack.pop();
			}
			if(!stack.isEmpty()){
				node = stack.pop().right;
				stack.push(node);
			} else{
				break;
			}
		}
		return res;
    }
	 * */
}
