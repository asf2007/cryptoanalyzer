package com.javarush.flyagin.cryptoanalyzer.service;

import java.nio.file.Files;
import java.nio.file.Path;

public  class Validation {
    public static String StringError;
    public static   boolean isFileExists(Path path){         //проверка существования файла
        if(path!=null&&Files.exists(path)){
            return true;
        } else {
            StringError =   "Не обнаружен файл";
            return false;
        }
    }
    public static boolean keyValidation(String key){    //проверка существования ключа


            try {
                Integer.parseInt(key);
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                StringError = "Не введен ключ";
                return false;
            } catch (NullPointerException ex){
                ex.printStackTrace();
                StringError = "Неверно введен ключ";
                return false;
            }

            return true;

    }
}
