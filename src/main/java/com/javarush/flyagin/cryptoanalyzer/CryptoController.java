package com.javarush.flyagin.cryptoanalyzer;

import com.javarush.flyagin.cryptoanalyzer.service.Cipher;
import com.javarush.flyagin.cryptoanalyzer.service.FileManager;
import com.javarush.flyagin.cryptoanalyzer.service.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptoController {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public TextField keyEncrypt;
    public Path fileEncrypt;
    public Path fileEncryptResult;
    public Path fileDecrypt;
    public TextField fileAddressEncrypt;
    public TextField fileAddressResultEncrypt;


    public void getFileEncrypt(ActionEvent actionEvent) {
        fileEncrypt = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressEncrypt.setText(fileEncrypt.toString());
    }

    public void onEncrypt(ActionEvent actionEvent) {
        Cipher cipher = new Cipher(ALPHABET);
        String str;


        if(Validation.isFileExists(fileEncrypt)) {
            BufferedReader bufferedReader = FileManager.readFile(fileEncrypt.toString());
            try {
                while ((str = bufferedReader.readLine()) != null){
                    FileManager.writeFile(cipher.encrypt(str, Integer.parseInt(keyEncrypt.getText())), fileEncryptResult.toString());
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }


    }

    public void getFileResultEncrypt(ActionEvent actionEvent) {
        fileEncryptResult = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressResultEncrypt.setText(fileEncryptResult.toString());
    }
}