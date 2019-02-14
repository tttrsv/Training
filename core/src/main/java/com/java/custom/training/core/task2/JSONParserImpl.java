package com.java.custom.training.core.task2;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.custom.training.core.task2.domain.dto.Users;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class JSONParserImpl implements Parser<Users, File> {

    @Override
    @SneakyThrows
    public File writeTo(Users object, String destination){
        File file = new File(destination);
        ObjectMapper objectMapper = new ObjectMapper();
        Objects.requireNonNull(object, "Users should not be null");
        objectMapper.writeValue(file, object);
        return file;
    }

    private boolean checkIfFileExist(File file) {
        return file.exists();
    }

    @Override
    @SneakyThrows
    public Users readFrom(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (!checkIfFileExist(file)) {
            throw new FileNotFoundException(file.getName());
        }
        return objectMapper.readValue(file, Users.class);
    }

}
