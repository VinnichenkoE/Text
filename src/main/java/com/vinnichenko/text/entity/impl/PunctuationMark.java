package com.vinnichenko.text.entity.impl;

import com.vinnichenko.text.entity.TextbookComponent;

public class PunctuationMark implements TextbookComponent {
    private final char punctuationMark;

    public PunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PunctuationMark that = (PunctuationMark) o;
        return punctuationMark == that.punctuationMark;
    }

    @Override
    public int hashCode() {
        return punctuationMark;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuationMark);
    }
}
