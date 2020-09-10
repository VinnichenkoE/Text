package com.vinnichenko.text.entity.impl;

import com.vinnichenko.text.entity.TextbookComponent;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextbookComponent {

    private List<Lexeme> lexemes = new ArrayList<>();

    public List<Lexeme> getLexemes() {
        return lexemes;
    }

    public void add(Lexeme lexeme) {
        lexemes.add(lexeme);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) o;
        return lexemes != null ? lexemes.equals(sentence.lexemes) : sentence.lexemes == null;
    }

    @Override
    public int hashCode() {
        return lexemes != null ? lexemes.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextbookComponent lexeme : lexemes) {
            stringBuilder.append(lexeme.toString()).append(" ");
        }
        return stringBuilder.toString();
    }
}
