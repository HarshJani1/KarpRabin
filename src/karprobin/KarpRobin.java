/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karprobin;

/**
 *
 * @author 91987
 */
public class KarpRobin {

    private final int PRIME = 101;

    private double countHash(String str) {
        double hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = hash + str.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        double patternHash = countHash(pattern);
        double textHash = countHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println(i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {

        KarpRobin algo = new KarpRobin();
        algo.search("abdchdksidba", "dba");
    }

}
