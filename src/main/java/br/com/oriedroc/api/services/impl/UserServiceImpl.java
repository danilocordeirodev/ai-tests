package br.com.oriedroc.api.services.impl;

import br.com.oriedroc.api.domain.User;
import br.com.oriedroc.api.repositories.UserRepository;
import br.com.oriedroc.api.services.UserService;
import br.com.oriedroc.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
