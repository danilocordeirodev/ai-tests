package br.com.oriedroc.api.services;

import br.com.oriedroc.api.domain.User;

public interface UserService {
    User findById(Integer id);
}
