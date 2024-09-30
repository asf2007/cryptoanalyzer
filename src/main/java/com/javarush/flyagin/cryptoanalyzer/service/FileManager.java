package com.javarush.flyagin.cryptoanalyzer.service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    String input;
    BufferedReader bufferedReader;
    String str;

    public FileManager(String input, String outPut) {
        this.input = input;
        this.outPut = outPut;
        streamInit();
    }

    String outPut;
    private void streamInit() { //создание потока bufferedReader
        try {
            this.bufferedReader = new BufferedReader(new FileReader(input, Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  String readFile() {



        try {
            this.str = this.bufferedReader.readLine(); //чтение файла построчно
            if(str!=null){
                return this.str;
            } else{
                this.bufferedReader.close();
                return this.str;
            }

        } catch (
                IOException ex) {
            throw new RuntimeException();
        }
    }

    public  void writeFile(String content, String path){   //запись в файл
        try(FileWriter fileWriter = new FileWriter(path, Charset.forName("UTF-8"), true)) {
           fileWriter.write(content);
           fileWriter.write("\n");
        }catch(IOException ex){
            throw new RuntimeException();
        }


    }
}
