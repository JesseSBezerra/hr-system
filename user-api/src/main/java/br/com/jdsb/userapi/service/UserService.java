package br.com.jdsb.userapi.service;

import br.com.jdsb.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();

}
