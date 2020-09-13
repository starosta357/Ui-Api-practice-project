package ui.util;

import service.TestDataReader;
import ui.model.User;

public class UserCreator {

    public static final String USER_NAME = "ui.user.name";
    public static final String USER_PASSWORD = "ui.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(USER_NAME), "");
    }
}
