package com.vinnichenko.text.entity.impl;

import com.vinnichenko.text.entity.TextbookComponent;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextbookComponent {
    private List<TextbookComponent> symbols = new ArrayList<>();

    public List<TextbookComponent> getSymbols() {
        return symbols;
    }

    public void add(TextbookComponent symbol) {
        symbols.add(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return symbols != null ? symbols.equals(word.symbols) : word.symbols == null;
    }

    @Override
    public int hashCode() {
        return symbols != null ? symbols.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextbookComponent symbol: symbols) {
            stringBuilder.append(symbol.toString());
        }
        return stringBuilder.toString();
    }
}
