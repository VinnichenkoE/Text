package com.vinnichenko.text.parser.impl;

import com.vinnichenko.text.entity.impl.Symbol;
import com.vinnichenko.text.entity.TextbookComponent;
import com.vinnichenko.text.entity.impl.Word;
import com.vinnichenko.text.parser.StringParser;

public class WordParser implements StringParser {

    public TextbookComponent parse(String stringWord) {
        char[] chars = stringWord.toCharArray();
        Word word = new Word();
        for (int i = 0; i < chars.length; i++) {
            Symbol symbol = new Symbol(chars[i]);
            word.add(symbol);
        }
        return word;
    }
}
