package com.vinnichenko.text.service.comparator;

import com.vinnichenko.text.entity.impl.Sentence;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {
    @Override
    public int compare(Sentence o1, Sentence o2) {
        return o1.getLexemes().size() - o2.getLexemes().size();
    }
}
