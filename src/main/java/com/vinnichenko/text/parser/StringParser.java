package com.vinnichenko.text.parser;

import com.vinnichenko.text.entity.TextbookComponent;

public interface StringParser {
    TextbookComponent parse(String line);
}
