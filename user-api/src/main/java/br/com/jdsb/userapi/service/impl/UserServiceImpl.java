package br.com.jdsb.userapi.service.impl;

import br.com.jdsb.userapi.domain.User;
import br.com.jdsb.userapi.repositories.UserRepository;
import br.com.jdsb.userapi.service.UserService;
import br.com.jdsb.userapi.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object not Found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
