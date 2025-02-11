public class CreateBT{
	
	//st1->inorder st2->preorder
	
	private static TreeNode helpFn(int[] inorder,int[] preorder,int st1,int st2,int en1,int en2){
	
		//If either inorder and preorder is empty then no tree can be formed
		if(st1>en1 || st2>en2){
			return null;	
		}
		
		//Root value is starting of preorder
		int root = preorder[st2];
		
		int i = st1;
		//find the root in inorder
		for(i =st1;i<en1;i++){
			if(inorder[i] == root){
				break;
			}
		}
		
		//inorder parameters for left subtree
		//st1 to i-1
		//preorder for left subtree
		//st1+1 to st2-st1+i
		
		TreeNode left = helpFn(inorder,preorder,st1,st2+1,i-1,st2+(i-st1));
		
		//preorder parameters for rightsubtree
		//st2-st1+i+1 to en2
		//inorder
		//i+1 to en1
		
		TreeNode right = helpFn(inorder,preorder,i+1,st2+1+i-st1,en1,en2);	
		
		
		TreeNode rootNode = new TreeNode(root,left,right);
		return rootNode;
	}
	
	public static void printInorder(TreeNode root){
		if(root == null){
			return;
		}
		
		printInorder(root.left);
		System.out.print(root.val+" ");
		printInorder(root.right);
	}
	
	public static void printPreorder(TreeNode root){
		if(root == null){
			return;
		}
		
		System.out.print(root.val+" ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	
	public static TreeNode createBT(int[] inorder, int[] preorder){
		return helpFn(inorder,preorder,0,0,inorder.length-1,preorder.length-1);
	}
	
	
	public static void main(String[] args){
		int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		
		TreeNode root = createBT(inorder,preorder);
		
		System.out.println("Inorder: ");
		printInorder(root);
		System.out.println();
		System.out.println("Preorder: ");
		printPreorder(root);
		System.out.println();
	}
}
