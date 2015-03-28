package test.algorithm;

import java.util.ArrayList;

import test.algorithm.BinarySearchTree.BinaryNode;

public class TestTreeNode {
	public static class TreeNode {
	    public TreeNode left, right;
	    public int val;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}

	public TreeNode arrayToTree(Integer[] input){
	    TreeNode root = createTreeNode(input,0);
	    return root;
	}

	private TreeNode createTreeNode(Integer[] input, int index){
	    if(index<input.length){
	        Integer value = input[index];
	        if(value!=null){
	            TreeNode t = new TreeNode(value);
	            t.left = createTreeNode(input, index*2+1);
	            t.right = createTreeNode(input, index*2+2);
	            return t;
	        }
	    }
	    return null;
	}

	
    private static ArrayList<Integer> getList(TreeNode root){
    	ArrayList<TreeNode> largelist = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> mlist = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> mlist2;
    	if(root != null){
    		mlist.add(root);
    	}
    	while(mlist.size()>0&&isContainElement(mlist)){
    		largelist.addAll(mlist);
    		mlist2= new ArrayList<TreeNode>();
    		for(TreeNode item: mlist){
    			if(null != item){
    			mlist2.add(item.left);
    			mlist2.add(item.right);
    			}else{
    				mlist2.add(null);
    				mlist2.add(null);
    			}
    		}
    		mlist = mlist2;

    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(TreeNode tn : largelist){
    		if(tn == null){
    			list.add(null);
    		}else{
    			list.add(tn.val);
    		}
    	}
    	
    	for(Integer it:list){
    		System.out.println(it);
    	}
    	return list;
    }
    
    private static boolean isContainElement(ArrayList<TreeNode> list){
    	 for(TreeNode bn:list){
    		 if(bn != null)
    			 return true;
    	 }
    	return false;
    }

    
    private TreeNode insert( int x, TreeNode t )
    {
/* 1*/      if( t == null )
/* 2*/          t = new TreeNode( x);
/* 3*/      else if( x<t.val)
/* 4*/          t.left = insert( x, t.left );
/* 5*/      else if(x >t.val )
/* 6*/          t.right = insert( x, t.right );
/* 7*/      else
/* 8*/          ;  // Duplicate; do nothing
/* 9*/      return t;
    }
    
    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    public TreeNode remove( int x, TreeNode t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
        if( x< t.val)
            t.left = remove( x, t.left );
        else if( x>t.val )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children, if x equals t.val
        {
            t.val = findMin( t.right ).val;
            t.right = remove( t.val, t.right );
        }
        else// x equals t.val
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }
    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private TreeNode findMin( TreeNode t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }
    
    private TreeNode findMax( TreeNode t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    
    
    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printInorderTree( TreeNode t )
    {
        if( t != null )
        {
        	printInorderTree( t.left );
            System.out.println( t.val );
            printInorderTree( t.right );
        }
    }
    
    
    private void printPreTree(TreeNode t){
        if( t != null )
        {
        	 System.out.println( t.val );
        	printPreTree( t.left );
          
            printPreTree( t.right );
        }
    }
    
    private void printPostTree(TreeNode t){
        if( t != null )
        {
        	
        	 printPostTree( t.left );
          
        	 printPostTree( t.right );
        	 System.out.println( t.val );
        }
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input ={1,null,2,null,null,3};
		TestTreeNode mt = new TestTreeNode();
		TreeNode root = mt.arrayToTree(input);
		System.out.println(root.val);
		
		System.out.println(getList(root));
		
		// insert 2,1,4,5,3
		TreeNode mroot = new TreeNode(2);
		mt.insert(2, mroot);
		mt.insert(1, mroot);
		mt.insert(4, mroot);
		mt.insert(5, mroot);
		mt.insert(3, mroot);
		mt.remove(4, mroot);
		System.out.println(getList(mroot));
		mt.printPreTree(mroot);
		mt.printInorderTree(mroot);

	}

}
