package com.vinnichenko.text.parser.impl;

import com.vinnichenko.text.entity.impl.Lexeme;
import com.vinnichenko.text.entity.impl.PunctuationMark;
import com.vinnichenko.text.entity.TextbookComponent;
import com.vinnichenko.text.parser.StringParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements StringParser {

    private StringParser nextParser = new WordParser();

    static final String REGEX_WORD = "(\\d*\\p{LC}*[-]*\\p{LC}*)(\\p{Punct}*)";

    public TextbookComponent parse(String stringLexeme) {
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(stringLexeme);
        Lexeme lexeme = new Lexeme();
        if(matcher.find()) {
            String word = matcher.group(1);
            lexeme.add(nextParser.parse(word));
            String stringPunctuationMark = matcher.group(2);
            for (int i = 0; i < stringPunctuationMark.length(); i++) {
                char[] marks = stringPunctuationMark.toCharArray();
                PunctuationMark punctuationMark = new PunctuationMark(marks[i]);
                lexeme.add(punctuationMark);
            }
        }
        return lexeme;
    }
}
