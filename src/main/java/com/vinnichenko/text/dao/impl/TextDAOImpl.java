package com.vinnichenko.text.dao.impl;

import com.vinnichenko.text.dao.TextDAO;
import com.vinnichenko.text.dao.util.FilePathReader;
import com.vinnichenko.text.entity.impl.Text;
import com.vinnichenko.text.exception.DAOException;
import com.vinnichenko.text.parser.impl.TextParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TextDAOImpl implements TextDAO {

    private TextParser textParser = new TextParser();

    @Override
    public Text findAll() throws DAOException {
        BufferedReader bufferedReader = null;
        List<String> lines;
        StringBuilder stringBuilder = new StringBuilder();
        String path = FilePathReader.getPath();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            throw new DAOException(ex);
        } finally {
            closeBufferReader(bufferedReader);
        }
        for (String line : lines) {
            stringBuilder.append(line);
        }
        Text text = (Text) textParser.parse(stringBuilder.toString());
        return text;
    }
}
