package de.ykstr.jnetsim.realistic.util;

public class ByteUtils {
    public static byte[] merge(byte... b){
        return b;
    }

    public static byte[] merge(byte[]... b){
        int size = 0;
        for(byte[] part : b){
            size+= part.length;
        }

        byte[] result = new byte[size];
        int i = 0;

        for(byte[] part : b){
            for(byte inner: part){
                result[i] = inner;
                i++;
            }
        }

        return result;
    }

    public static byte[] merge(byte[] arr, byte... b){
        byte[] result = new byte[arr.length+b.length];
        for(int i = 0; i<arr.length; i++){
            result[i] = arr[i];
        }

        for(int i = 0; i<b.length; i++){
            result[i+arr.length] = b[i];
        }
        return result;
    }

    public static byte[] shortToByte(short s){
        byte[] result = new byte[2];
        result[0] = (byte)(s >> 8);
        result[1] = (byte)s;
        return result;
    }

    public static byte[] intArrayToByteArray(int[] arr){
        byte[] result = new byte[arr.length*4];
        for(int i = 0;i<arr.length*4;i++){
            int x = arr[i/4];
            result[i] = (byte)(x >> (3-i%4)*8);
        }
        return result;
    }
}
