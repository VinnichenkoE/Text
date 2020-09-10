package com.vinnichenko.text.parser.impl;

import com.vinnichenko.text.entity.impl.Sentence;
import com.vinnichenko.text.entity.impl.Text;
import com.vinnichenko.text.entity.TextbookComponent;
import com.vinnichenko.text.parser.StringParser;

public class TextParser implements StringParser {

    private StringParser nextParser = new SentenceParser();

    private static final String SENTENCE_REGEX = "(?<=[.?!])";

    public TextbookComponent parse(String stringText) {
        String[] sentences = stringText.split(SENTENCE_REGEX);
        Text text = new Text();
        for (int i = 0; i < sentences.length; i++) {
            text.add((Sentence) nextParser.parse(sentences[i].trim()));
        }
        return text;
    }
}
