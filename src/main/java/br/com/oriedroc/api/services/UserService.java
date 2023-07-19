package br.com.oriedroc.api.services;

import br.com.oriedroc.api.domain.User;
import br.com.oriedroc.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO userDTO);
}
