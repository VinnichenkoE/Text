package com.vinnichenko.text.dao;

import com.vinnichenko.text.entity.impl.Text;
import com.vinnichenko.text.exception.DAOException;

import java.io.BufferedReader;
import java.io.IOException;

public interface TextDAO {
    public Text findAll() throws DAOException;

    default void closeBufferReader(BufferedReader bufferedReader)
            throws DAOException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new DAOException(e);
            }
        }
    }
}
