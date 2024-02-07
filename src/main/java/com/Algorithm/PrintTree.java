package com.Algorithm;

public class PrintTree {
    private static class Trunk {
        Trunk prev;
        String str;

        private Trunk(Trunk prev, String str) {
            this.prev = prev;
            this.str = str;
        }
    }

    // Helper function to print branches of the binary tree
    private static void showTrunks(Trunk p) {
        if (p == null)
            return;
        showTrunks(p.prev);

        System.out.print(p.str);
    }
    
    private static void traversalPrint(Node root, Trunk prev, boolean isLeft) {
        if (root == null)
            return;
        String ROOT_PREV                    = "   ";
        String CHILD_PREV                   = "    ";
        String LEFT_CHILD_CURVED_EDGE       = ".---";
        String LEFT_CHILD_STRAIGHT_EDGE     = "   |";
        String RIGHT_CHILD_CURVED_EDGE      = "`---";
        String RIGHT_CHILD_STRAIGHT_EDGE    = "   |";
        String prev_str = CHILD_PREV;
        Trunk trunk = new Trunk(prev, prev_str);
       
        if (!root.nexts.isEmpty())
            for (Node value : root.nexts.values()) {
                traversalPrint(value, trunk, true);
                break;
            }
        if (prev == null)
            trunk.str = ROOT_PREV;
        else if (isLeft(isLeft)) {
            trunk.str = LEFT_CHILD_CURVED_EDGE;
            prev_str = LEFT_CHILD_STRAIGHT_EDGE;
        } else {
            trunk.str = RIGHT_CHILD_CURVED_EDGE;
            prev.str = prev_str;
        }
        
        if(root.data!=null){
            showTrunks(trunk);
            System.out.println(root.data);
        }
        if (prev != null)
            prev.str = prev_str;
        trunk.str = RIGHT_CHILD_STRAIGHT_EDGE;
        
        if (root.nexts.size()>=2){
            int flag=0;
            for (Node value : root.nexts.values()) {
                if(flag==0){
                    flag=1;
                }
                else {
                    traversalPrint(value, trunk, false);
                    break;
                }
            }
        }

    }

    private static boolean isLeft(boolean isLeft) {
        return isLeft;
    }

    public static void print(Node root) {
        traversalPrint(root, null, false);
    }



}