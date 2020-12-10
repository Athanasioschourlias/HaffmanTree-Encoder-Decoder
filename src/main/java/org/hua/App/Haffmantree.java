package org.hua.App;

public class Haffmantree {

    //this is the class where we create the template for the nodes of the binnary tree.
    public static class Node implements Comparable<Node>{
        public int frequency;
        public int letter;//if the node is a leaf we store the letter of this node.
        public Node left, right;

        public Node(int frequency, int letter){
            this.frequency = frequency;
            this.letter = letter;
            this.left = null;
            this.right = null;

        }

        @Override
        public int compareTo(Node o) {
            int freqComp = Integer.compare(this.frequency, o.frequency);
            if(freqComp !=0){
                return freqComp;
            }
            return Integer.compare(this.letter, o.letter);
        }
    }


}
