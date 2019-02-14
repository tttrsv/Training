package com.java.custom.training.core.task2;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.java.custom.training.core.task2.domain.ParserType;
import com.java.custom.training.core.task2.domain.dto.Users;
import com.java.custom.training.core.task2.utils.TestConstants;
import com.java.custom.training.core.task2.utils.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;


public class CustomXMLParserImplTest {
    private Parser xmlParser;
    private Users users;

    @Before
    public void setUp() {
        xmlParser = new AbstractFactoryImpl().createParser(ParserType.XML);
        users = TestHelper.createUsers();
    }

    @Test
    public void writeToTest() {
        xmlParser.writeTo(users, TestConstants.XML_FILE_PATH_WRITE);
    }

    @Test
    public void readFromTest() {
        xmlParser.readFrom(new File(TestConstants.XML_FILE_PATH_READ));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenFileNotFound(){
        xmlParser.readFrom(new File(TestConstants.XML_FILE_PATH_INVALID));
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void shouldThrowExceptionWhenXMLStructureIsInvalid(){
        xmlParser.readFrom(new File(TestConstants.XML_FILE_PATH_INVALID_STRUCTURE));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenObjectIsNull(){
        xmlParser.writeTo(null, TestConstants.XML_FILE_PATH_WRITE);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenFileObjectIsNull(){
        xmlParser.readFrom(null);
    }

    @Test
    public void readFromTestNotNullObject() {
        Users actual = (Users) xmlParser.readFrom(new File(TestConstants.XML_FILE_PATH_READ));
        Assert.assertNotNull(actual);
    }
}