package fi.c5msiren.service;

import fi.c5msiren.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}