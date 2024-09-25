package com.javarush.flyagin.cryptoanalyzer;

import com.javarush.flyagin.cryptoanalyzer.service.Cipher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CryptoController {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        System.out.println(new Cipher(ALPHABET).decrypt("ввввввв", 41));

    }
}