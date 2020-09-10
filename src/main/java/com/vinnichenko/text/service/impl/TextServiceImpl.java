package com.vinnichenko.text.service.impl;

import com.vinnichenko.text.entity.TextbookComponent;
import com.vinnichenko.text.entity.impl.Lexeme;
import com.vinnichenko.text.entity.impl.Sentence;
import com.vinnichenko.text.entity.impl.Text;
import com.vinnichenko.text.entity.impl.Word;
import com.vinnichenko.text.exception.ServiceException;
import com.vinnichenko.text.parser.impl.WordParser;
import com.vinnichenko.text.service.TextService;
import com.vinnichenko.text.service.comparator.SentenceComparator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {

    private static final String REGEX_WORD_START_WITH_CONSONANT =
            "\\b[^AEIOUaeiouАОУЫЭЯЁЮИЕаоуыэяёюие]\\p{LC}*\\b";

    @Override
    public Text deleteWordsStartConsonant(Text text, int length) throws ServiceException {
        if (text == null || length <= 0) {
            throw new ServiceException("incorrect parameters");
        }
        text.getSentences()
                .forEach(sentence -> sentence.getLexemes()
                        .forEach(lexeme -> {
                            List<TextbookComponent> componentsToRemove =
                                    lexeme.getWordOrPunctuationMark().stream()
                                            .filter(w -> w instanceof Word)
                                            .filter(w -> w.toString().length() == length)
                                            .filter(w -> isStartWithConsonant(w.toString()))
                                            .collect(Collectors.toList());
                            lexeme.getWordOrPunctuationMark().removeAll(componentsToRemove);
                        }));
        return text;
    }

    @Override
    public Text sortBySentenceLength(Text text) {
        text.getSentences().sort(new SentenceComparator());
        return text;
    }

    @Override
    public Text changeGivenLengthWordBySubstring(Text text, int length,
                                                 String substring)
            throws ServiceException {
        if (text == null || length <= 0 || substring == null) {
            throw new ServiceException("incorrect parameters");
        }
        List<Sentence> sentences = text.getSentences();
        WordParser wordParser = new WordParser();
        for (Sentence sentence : sentences) {
            List<Lexeme> lexemes = sentence.getLexemes();
            for (int i = 0; i < lexemes.size(); i++) {
                String word = lexemes.get(i).getWordOrPunctuationMark()
                        .get(0).toString();
                if (word.length() == length) {
                    lexemes.get(i).getWordOrPunctuationMark()
                            .set(0, wordParser.parse(substring));
                }
            }
        }
        return text;
    }

    private boolean isStartWithConsonant(String word) {
        Pattern pattern = Pattern.compile(REGEX_WORD_START_WITH_CONSONANT);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }
}
