package com.java.custom.training.core.task2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.java.custom.training.core.task2.domain.dto.Users;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Objects;

public class XMLParserImpl implements Parser<Users, File> {

    @Override
    @SneakyThrows
    public File writeTo(Users object, String destination) {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(destination);
        if (!checkIfFileExist(file)) {
            throw new FileNotFoundException(file.getName());
        }
        Objects.requireNonNull(object, "Users should not be null");
        xmlMapper.writeValue(file, object);
        return file;
    }

    @Override
    @SneakyThrows
    public Users readFrom(File file) {
        XmlMapper xmlMapper = new XmlMapper();
        if(!checkIfFileExist(file)){
            throw new FileNotFoundException(file.getName());
        }
        String xml = inputStreamToString(new FileInputStream(file));
        return xmlMapper.readValue(xml, Users.class);
    }

    private boolean checkIfFileExist(File file) {
        return file.exists();
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
