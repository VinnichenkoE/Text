package com.vinnichenko.text.entity.impl;

import com.vinnichenko.text.entity.TextbookComponent;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextbookComponent {

    private List<Sentence> sentences = new ArrayList<>();

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        return sentences != null ? sentences.equals(text.sentences) : text.sentences == null;
    }

    @Override
    public int hashCode() {
        return sentences != null ? sentences.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextbookComponent sentence: sentences) {
            stringBuilder.append(sentence.toString());
        }
        return stringBuilder.toString();
    }
}
