/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    int counter = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder("");

        serializeHelper(root, sb);

        return sb.toString();
        
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {

        if(root==null)
         {
            sb.append("#,");
            return;
         }

         sb.append(root.val+",");
         serializeHelper(root.left, sb);
         serializeHelper(root.right, sb);




    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        int i = 0;
        int n = data.length();

        String [] arr = data.split(",");

        for(String s : arr){
            System.out.print(s+" ");
        }

        System.out.println();

        return deserializeHelper(arr);

        
    }
    public TreeNode deserializeHelper(String [] arr) {

        int n = arr.length;

     



        if(counter >= n || arr[counter].isEmpty() || arr[counter].equals("#"))
        {
            counter++;
        return null;
        }

     

        TreeNode root = new TreeNode(Integer.parseInt(arr[counter]));

        counter++;

        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);

        return root;





        
    }
}
