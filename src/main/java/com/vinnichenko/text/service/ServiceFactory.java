package com.vinnichenko.text.service;

import com.vinnichenko.text.service.impl.TextServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextService() {
        return textService;
    }
}
