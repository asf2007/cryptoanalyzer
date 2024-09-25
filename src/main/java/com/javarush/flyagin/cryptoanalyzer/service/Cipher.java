package com.javarush.flyagin.cryptoanalyzer.service;

import java.util.HashMap;
import java.util.HashSet;

public class Cipher {
    private char[] alphabet;
    private HashMap<Character, Integer> alphabetHashMap;
    
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
        this.alphabetHashMap = alphabetToHashMap(alphabet);
    }

    public String encrypt(String text, int key) {
        // Логика шифрования
        int number = 0;
        int reminder = 0;
        String textLC = text.toLowerCase();
        char [] charText = textLC.toCharArray();
        StringBuilder stringOut = new StringBuilder();
        for (int i = 0; i < charText.length; i++) {
            number = alphabetHashMap.get(charText[i]);
            reminder = (number + key)%alphabet.length;
            stringOut.append(alphabet[reminder]);

        }
        

        return stringOut.toString();
    }
    public String decrypt(String encryptedText, int key) {
        // Логика расшифровки
        return encrypt(encryptedText, alphabet.length - key%alphabet.length);
    }
    public HashMap<Character, Integer> alphabetToHashMap(char[] alphabetCrypto){ //перевод алфавита в hashmap
        HashMap<Character, Integer> hashMapAlphabetCrypto = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            hashMapAlphabetCrypto.put(alphabet[i], i);
        }
        return hashMapAlphabetCrypto;
    }
}
