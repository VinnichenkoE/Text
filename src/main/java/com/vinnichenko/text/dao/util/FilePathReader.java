package com.vinnichenko.text.dao.util;

import com.vinnichenko.text.exception.DAOException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FilePathReader {
    private static final String FILE = "file";
    private static final String KEY = "file.path";

    public static String getPath() throws DAOException {
        String path;
        ResourceBundle resource = ResourceBundle.getBundle(FILE);
        try {
            path = resource.getString(KEY);
        } catch (MissingResourceException ex) {
            throw new DAOException(ex);
        }
        return path;
    }
}
