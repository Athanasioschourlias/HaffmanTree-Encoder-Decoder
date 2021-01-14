//package org.hua.App;
//
//import java.util.BitSet;
//
//public class test {
//
//
//
//        //if the bit we wrote at this Bitset do not have padding
//        if( (cdmap[nextChar].length() % 8) != 0 ){
//            if(stuck.isEmpty()) {
//                //if the bitset has some padding then we are making an object that
//                EncodingFile.BitCount b = new EncodingFile.BitCount((cdmap[nextChar].length() % 8), buffer);
//                stuck.add(b);
//            }else {
//                BitSet b2;
//                BitSet tmp = new BitSet();
//
//                EncodingFile.BitCount b = stuck.pop();
//
//                b2 = b.byff;
//
//                for(int i = 0; i < b2.length(); i++){
//
//
//
//                }
//
//
//            }
//
//        }else {
//            //if the Bitset DOES NOT HAVE PADDING WE JUST WRITE IT TO THE FILE.
//            out.write(buffer.toByteArray());
//        }
//        private static class BitCount{
//
//            public double bits;
//            public BitSet byff;
//
//            public BitCount(double bits, BitSet byff){
//                this.bits=bits;
//                this.byff=byff;
//
//            }
//
//        }
//
//}
