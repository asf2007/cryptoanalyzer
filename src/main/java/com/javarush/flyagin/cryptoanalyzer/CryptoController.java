package com.javarush.flyagin.cryptoanalyzer;

import com.javarush.flyagin.cryptoanalyzer.service.Cipher;
import com.javarush.flyagin.cryptoanalyzer.service.FileManager;
import com.javarush.flyagin.cryptoanalyzer.service.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CryptoController implements Initializable {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public TextField keyEncrypt;
    public Path fileEncrypt;
    public Path fileEncryptResult;
    public Path fileDecrypt;
    public Path fileDecryptResult;
    public TextField fileAddressEncrypt;
    public TextField fileAddressResultEncrypt;
    public TextField fileAddressDecrypt;
    public TextField keyDecrypt;
    public TextField fileAddressResultDecrypt;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileAddressEncrypt.setDisable(true);
        fileAddressResultEncrypt.setDisable(true);
        fileAddressDecrypt.setDisable(true);
        fileAddressResultDecrypt.setDisable(true);
    }



    public void getFileEncrypt(ActionEvent actionEvent) {
        fileEncrypt = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressEncrypt.setText(fileEncrypt.toString());
    }

    public void onEncrypt(ActionEvent actionEvent) {
        Cipher cipher = new Cipher(ALPHABET);
        String str;
        if (!Validation.isFileExists(fileEncrypt)||!Validation.keyValidation(keyEncrypt.getText())){
            Alert errorValid = new Alert(Alert.AlertType.ERROR, Validation.StringError +" для шифрования!" );
            errorValid.showAndWait();
        }else if(!Validation.isFileExists(fileEncryptResult)){
            Alert errorValid = new Alert(Alert.AlertType.ERROR, Validation.StringError +" для результата шифрования!" );
            errorValid.showAndWait();
        }else{
            FileManager fileManager = new FileManager(fileEncrypt.toString(), fileEncryptResult.toString());

            while ((str = fileManager.readFile()) != null) {

                fileManager.writeFile(cipher.encrypt(str, Integer.parseInt(keyEncrypt.getText())), fileEncryptResult.toString());

            }
            Alert finishEncrypt = new Alert(Alert.AlertType.INFORMATION, "Шифрование окончено!");
            finishEncrypt.showAndWait();
        }


    }

    public void getFileResultEncrypt(ActionEvent actionEvent) {
        fileEncryptResult = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressResultEncrypt.setText(fileEncryptResult.toString());
    }

    public void getFileResultDecrypt(ActionEvent actionEvent) {
        fileDecryptResult = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressResultDecrypt.setText(fileDecryptResult.toString());
    }

    public void onDecrypt(ActionEvent actionEvent) {
        Cipher cipher = new Cipher(ALPHABET);
        String str;
        if (!Validation.isFileExists(fileDecrypt)||!Validation.keyValidation(keyDecrypt.getText())){
            Alert errorValid = new Alert(Alert.AlertType.ERROR, Validation.StringError +" для расшифрования!");
            errorValid.showAndWait();
        } else if(!Validation.isFileExists(fileDecryptResult)){
        Alert errorValid = new Alert(Alert.AlertType.ERROR, Validation.StringError +" для результата расшифрования!" );
        errorValid.showAndWait();
        } else{
            FileManager fileManager = new FileManager(fileDecrypt.toString(), fileDecryptResult.toString());

            while ((str = fileManager.readFile()) != null) {

                fileManager.writeFile(cipher.decrypt(str, Integer.parseInt(keyDecrypt.getText())), fileDecryptResult.toString());

            }
            Alert finishEncrypt = new Alert(Alert.AlertType.INFORMATION, "Расшифрование окончено!");
            finishEncrypt.showAndWait();
        }
    }

    public void getFileDecrypt(ActionEvent actionEvent) {
        fileDecrypt = Path.of(new FileChooser().showOpenDialog(new Stage()).getPath());
        fileAddressDecrypt.setText(fileDecrypt.toString());
    }
}