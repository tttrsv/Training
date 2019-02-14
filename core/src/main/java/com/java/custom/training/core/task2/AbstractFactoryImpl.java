package com.java.custom.training.core.task2;

import com.java.custom.training.core.task2.domain.ParserType;

public class AbstractFactoryImpl extends AbstractFactory {

    @Override
    public Parser createParser(ParserType type) {
        switch (type) {
            case XML:
                return new XMLParserImpl();
            case JSON:
                return new JSONParserImpl();
        }
        return null;
    }
}
