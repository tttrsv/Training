package com.java.custom.training.core.task2;

import com.java.custom.training.core.task2.domain.ParserType;

public abstract class AbstractFactory {
    public abstract Parser createParser(ParserType type);
}
