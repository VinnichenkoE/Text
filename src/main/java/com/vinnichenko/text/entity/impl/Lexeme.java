package com.vinnichenko.text.entity.impl;

import com.vinnichenko.text.entity.TextbookComponent;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements TextbookComponent {

    private List<TextbookComponent> wordOrPunctuationMark = new ArrayList<>();

    public List<TextbookComponent> getWordOrPunctuationMark() {
        return wordOrPunctuationMark;
    }

    public void add(TextbookComponent component) {
        wordOrPunctuationMark.add(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return wordOrPunctuationMark != null ? wordOrPunctuationMark.equals(lexeme.wordOrPunctuationMark) : lexeme.wordOrPunctuationMark == null;
    }

    @Override
    public int hashCode() {
        return wordOrPunctuationMark != null ? wordOrPunctuationMark.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextbookComponent component : wordOrPunctuationMark) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }
}
