package com.vinnichenko.text.dao;

import com.vinnichenko.text.dao.impl.TextDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TextDAO textDAO = new TextDAOImpl();

    private DAOFactory() {
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
