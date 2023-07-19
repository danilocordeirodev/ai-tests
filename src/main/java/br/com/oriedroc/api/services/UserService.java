package br.com.oriedroc.api.services;

import br.com.oriedroc.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();
}
