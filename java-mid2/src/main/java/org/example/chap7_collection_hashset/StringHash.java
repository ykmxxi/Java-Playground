package org.example.chap7_collection_hashset;

public class StringHash {

    public static int hashCode(final String str) {
        char[] charArray = str.toCharArray();
        int hashCode = 0;

        for (char ch : charArray) {
            hashCode += (int) ch;
        }
        return hashCode;
    }

}
