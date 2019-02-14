package com.java.custom.training.core.task2;


import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.java.custom.training.core.task2.domain.ParserType;
import com.java.custom.training.core.task2.domain.dto.User;
import com.java.custom.training.core.task2.domain.dto.Users;
import com.java.custom.training.core.task2.utils.TestConstants;
import com.java.custom.training.core.task2.utils.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CustomJsonParserTest {
    private Parser jsonParser;
    private Users users;

    @Before
    public void setUp() {
        jsonParser = new AbstractFactoryImpl().createParser(ParserType.JSON);
        users = TestHelper.createUsers();
    }

    @Test
    public void writeToTest() {
        jsonParser.writeTo(users, TestConstants.JSON_FILE_PATH_WRITE);
    }

    @Test
    public void readFromTest() {
        jsonParser.readFrom(new File(TestConstants.JSON_FILE_PATH_READ));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenFileNotFound(){
        jsonParser.readFrom(new File(TestConstants.JSON_FILE_PATH_INVALID));
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void shouldThrowExceptionWhenXMLStructureIsInvalid(){
        jsonParser.readFrom(new File(TestConstants.JSON_FILE_PATH_INVALID_STRUCTURE));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenObjectIsNull(){
        jsonParser.writeTo(null, TestConstants.JSON_FILE_PATH_WRITE);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenFileObjectIsNull(){
        jsonParser.readFrom(null);
    }

    @Parameterized.Parameters
    public static Collection<Users> data() {
        return Arrays.asList(TestHelper.createUsers()
        );
    }

    @ParameterizedTest
    //@ValueSource (strings = {"John", "Steve", "Patrick"})
    @MethodSource("data")
    public void shouldBeNotNullObjectAfterReading(Users users) {
        jsonParser = new AbstractFactoryImpl().createParser(ParserType.JSON);
        Users actual = (Users) jsonParser.readFrom(new File(TestConstants.JSON_FILE_PATH_READ));
        for (User u: actual.getUsers()) {
           // assertEquals(, u.getName());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"foo", "bar", "baz"})
    void testIsNotBlank(String testValue) {

        assertFalse(testValue.isEmpty());
    }

    static Stream<String> blankStrings() {
        return Stream.of("йцукккк", "йцуке", "123");
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void isBlank(final String testValue) {
        Assertions.assertFalse(testValue.isEmpty());
    }
}