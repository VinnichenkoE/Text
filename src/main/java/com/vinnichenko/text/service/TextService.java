package com.vinnichenko.text.service;

import com.vinnichenko.text.entity.impl.Text;
import com.vinnichenko.text.exception.ServiceException;

public interface TextService {
    Text deleteWordsStartConsonant(Text text, int length)
            throws ServiceException;

    Text sortBySentenceLength(Text text);

    Text changeGivenLengthWordBySubstring(Text text, int Length, String substring)
            throws ServiceException;
}
