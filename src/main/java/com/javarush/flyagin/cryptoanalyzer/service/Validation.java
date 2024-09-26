package com.javarush.flyagin.cryptoanalyzer.service;

import java.nio.file.Files;
import java.nio.file.Path;

public  class Validation {
    public static   boolean isFileExists(Path path){         //проверка существования файла
        if(Files.exists(path)){
            return true;
        } else {
            return false;
        }
    }
}
