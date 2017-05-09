package fi.c5msiren.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}