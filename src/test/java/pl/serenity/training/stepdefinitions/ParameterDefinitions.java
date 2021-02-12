package pl.serenity.training.stepdefinitions;

import io.cucumber.java.ParameterType;

public class ParameterDefinitions {

    @ParameterType(".*")
    public String login(String login) {
        return login;
    }

    @ParameterType(".*")
    public String password(String password) {
        return password;
    }
}
