package org.hua.App;

public class Decoder
{
    public static void main(String[] args)
    {
        int[] codings;
        Huffmantree.Node root;
        DecodingFile decode=new DecodingFile();
        Huffmantree huffmantree = new Huffmantree();
        codings=decode.readHufFile(args[0]);
        root= huffmantree.getTree();
        //Now you have an int Array with all bits and the root node of the tree
        //Create a method that take each int and uses the tree to find the letters
        // if int==0 go left if int==1 go right
        // if is.leaf print into the file args[1]

    }
}
