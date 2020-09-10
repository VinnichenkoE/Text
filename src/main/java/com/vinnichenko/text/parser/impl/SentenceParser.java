package com.vinnichenko.text.parser.impl;

import com.vinnichenko.text.entity.impl.Lexeme;
import com.vinnichenko.text.entity.impl.Sentence;
import com.vinnichenko.text.entity.TextbookComponent;
import com.vinnichenko.text.parser.StringParser;

public class SentenceParser implements StringParser {

    private StringParser nextParser = new LexemeParser();

    static final String REGEX_LEXEME = "\\s+";

    public TextbookComponent parse(String stringSentence) {
        Sentence sentence = new Sentence();
        String[] stringLexemes = stringSentence.split(REGEX_LEXEME);
        for (int i = 0; i < stringLexemes.length; i++) {
            sentence.add((Lexeme) nextParser.parse(stringLexemes[i]));
        }
        return sentence;
    }
}
