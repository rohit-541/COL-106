import java.util.*;

public class ZigZag{
	
	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null){
			return ans;
		}
		
		Queue<TreeNode> myQ = new LinkedList<TreeNode>();		
		
		myQ.offer(root);
		int levelNumber = 0;
		
		while(myQ.isEmpty() == false){
			int levelSize = myQ.size();
			List<Integer> level = new ArrayList<>();

			for(int i =0;i<levelSize;i++){
				TreeNode front = myQ.poll();
				
				level.add(front.val);
				
				if(front.left != null){
					myQ.offer(front.left);
				}
				
				if(front.right != null){
					myQ.offer(front.right);
				}
			}
			
			if(levelNumber % 2 != 0){
				
				reverse(level);
			}
			
			ans.add(level);
			levelNumber++;
		}
		
		
		return ans;
	}
	
	public static void reverse(List<Integer> list){
		int i = 0;
		int j = list.size()-1;
		
		while(i<j){
			int temp = list.get(i);
			list.set(i,list.get(j));
			list.set(j,temp);
			i++;
			j--;
		}
	}
	
	public static void print(List<List<Integer>> nums){
		for(int i =0;i<nums.size();i++){
			for(int j =0;j<nums.get(i).size();j++){
				System.out.print(nums.get(i).get(j)+" ");
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args){
		int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		
		TreeNode root = CreateBT.createBT(inorder,preorder);
		
		List<List<Integer>> ans = levelOrder(root);
		
		print(ans);
	}
}
