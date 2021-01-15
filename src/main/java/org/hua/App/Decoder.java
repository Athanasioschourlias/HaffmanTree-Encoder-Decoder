package org.hua.App;

import java.util.Arrays;

public class Decoder
{
    
    
    
    //Decompressing the array of 0 and 1
    public static String decompress(int[] codings){
        
        StringBuilder sb = new StringBuilder();
        //creating our huffmantree object
        Huffmantree huffmantree = new Huffmantree();
        //returning the root of the tree
        Huffmantree.Node root = huffmantree.getTree();
        //setting root as the current 
        Huffmantree.Node cur = root;
        
        int i =0;
        while(i<codings.length){
            //while current node not a leaf do the ifs depending on the int of the array
            while(!cur.isLeaf()){
                int bit = codings[i];
                if(bit==1){
                    cur=cur.right;
                }else if (bit==0){
                    cur=cur.left;
                }else{
                    throw new IllegalArgumentException("Invalid bit: "+bit);
                }
                i++;
            }
            //append to string builder
            //casting integer to character
            sb.append((char)cur.letter);
            cur= root;
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        
        DecodingFile decode=new DecodingFile();
        int[] codings = decode.readHufFile(args[0]);
        String dec = decompress(codings);
        System.out.println("The Decoded Message Is: "+dec);
        
        //the bits in our array from decodinfile
        System.out.println(Arrays.toString(codings));
        //codings=decode.readHufFile(args[0]);
        //Now you have an int Array with all bits and the root node of the tree
        //Create a method that take each int and uses the tree to find the letters
        // if int==0 go left if int==1 go right
        // if is.leaf print into the file args[1]
        
        
    }
}
