package writer;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Vignere implements Encripta{

    private static Scanner in;
    private static String message;
    private static String mappedKey;
    static PrintStream out = System.out;

    @Override
    public void encripta(String texto) throws IOException {

        int codigo = 5;

        out.println("Examen 1 / Parte 3");
        out.println("Alonso Cortés");
        out.println(" ");
        msgAndKey(texto);
        out.println("El texto encriptado es: " + cipherEncryption(message, mappedKey));

    }

    @Override
    public void desencripta(String texto) throws IOException {

        int codigo = 5;

        out.println("Examen 1 / Parte 3");
        out.println("Alonso Cortés");
        out.println(" ");
        msgAndKey(texto);
        System.out.println("El texto desencriptado es: " + cipherDecryption(message, mappedKey));

    }

    public static String cipherEncryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String encryptedText = "";
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                encryptedText += " ";
            } else {
                //accessing element at table[i][j] position to replace it with letter in message
                encryptedText += (char)table[(int)message.charAt(i)-65][(int)mappedKey.charAt(i)-65];
            }
        }

        return encryptedText;
    }

    public static String cipherDecryption(String message, String mappedKey) {
        int[][] table = createVigenereTable();
        String decryptedText = "";

        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                decryptedText += " ";
            } else {
                decryptedText += (char)(65 + itrCount((int)mappedKey.charAt(i), (int)message.charAt(i)));
            }
        }

        return decryptedText;
    }

    private static int itrCount(int key, int msg) {
        // this function will return the count which it takes from key's letter to reach cipher letter
        // and then this count will be used to calculate decryption of encrypted letter in message.
        int counter = 0;
        String result = "";
        for (int i = 0; i < 26; i++) {
            if(key+i > 90){
                //90 being ASCII of Z
                result += (char)(key+(i-26));

            } else {
                result += (char)(key+i);
            }
        }

        //counting from key's letter to cipher letter in vigenere table
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == msg){
                break; // letter found
            } else {
                counter++;
            }
        }
        return counter;
    }

    private static int[][] createVigenereTable() {
        // creating 26x26 table containing alphabets
        int[][] tableArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int temp;
                if((i+65)+j > 90){
                    temp = ((i+65)+j) -26;
                    tableArr[i][j] = temp;
                } else {
                    temp = (i+65)+j;
                    tableArr[i][j] = temp;
                }
            }
        }

        return tableArr;
    }

    private static void msgAndKey(String text) {
        String msg = text;
        msg = msg.toUpperCase();

        String key = "LIME";

        //mapping key to message
        String keyMap = "";
        for (int i = 0, j = 0; i < msg.length(); i++) {
            if(msg.charAt(i) == (char)32){
                //ignoring space
                keyMap += (char)32;

            } else {
                //mapping letters of key with message
                if(j < key.length()){
                    keyMap += key.charAt(j);
                    j++;
                } else {
                    //restarting the key from beginning once its length is complete
                    // and its still not mapped to message
                    j = 0;
                    keyMap += key.charAt(j);
                    j++; //without incrementing here, key's first letter will be mapped twice

                }
            } //if-else

        } //for
        message = msg;
        mappedKey = keyMap;
    }
}
