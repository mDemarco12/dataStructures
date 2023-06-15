package partI;


import util.BinaryNode;



public class Question1 {
    public static int countEqualToValue(BinaryNode<Integer> root, int value){
        if(root == null)
            return 0;
        if(root.element == value)
            return 1 + countEqualToValue(root.left, value)
                    + countEqualToValue(root.right, value);
        else
            return countEqualToValue(root.left, value)
                    + countEqualToValue(root.right, value);
    }

    public static boolean isBalanced(BinaryNode<Integer> root){
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null)
            return root.right.left == null && root.right.right == null;
        if(root.right == null)
            return root.left.left == null && root.left.right == null;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(root.left.height()-root.right.height()) < 2;
    }

    public static boolean isSymmetric(BinaryNode<Integer> root) {
        //Gets binaryTree
        //Returns a boolean if the tree mirrors itself

        if ((root.left == root.right)) {
            return true;
        }if(root.left.left == root.right.right){
            return true;
        }if(root.left.right == root.right.left){
            return true;
        }else
            return isSymmetric(root.left) && isSymmetric(root.right)
                    && Math.abs(root.left.height() - root.right.height()) < 1;


    }

    public static BinaryNode<Integer> removeLeaves(BinaryNode<Integer> root){
    //gets binaryTree and removes all the leaves and returns the root

        if(root == null ) {
            return null;

        }if( (root.left == null && root.right == null)){
            root.left = removeLeaves(root.left);
            root.right = removeLeaves(root.right);
        }

        root.left = null;
        root.right = null ;


        return root;

    }
    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<>(1,
//                new BinaryNode<>(4, new BinaryNode<>(5), new BinaryNode<>(4)),
//                new BinaryNode<>(7, new BinaryNode<>(4), new BinaryNode<>(6)));
                new BinaryNode<>(2, new BinaryNode<>(3), new BinaryNode<>(4)),
                new BinaryNode<>(2, new BinaryNode<>(4), new BinaryNode<>(3)));
        System.out.println(root);

        System.out.println("Is the tree symmetrical?");
        System.out.println(isSymmetric(root) + "\n");

        System.out.println("Remove all numbers except root!");
        System.out.println(removeLeaves(root));

    }
}
