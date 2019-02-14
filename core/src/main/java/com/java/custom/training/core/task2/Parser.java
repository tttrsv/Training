package com.java.custom.training.core.task2;

interface  Parser<Target, Output> {

     Output writeTo(Target object, String destination);

     Target readFrom(Output file);

}
