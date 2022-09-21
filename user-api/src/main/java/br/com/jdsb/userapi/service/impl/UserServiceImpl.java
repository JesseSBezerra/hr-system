package br.com.jdsb.userapi.service.impl;

import br.com.jdsb.userapi.domain.User;
import br.com.jdsb.userapi.repositories.UserRepository;
import br.com.jdsb.userapi.service.UserService;
import br.com.jdsb.userapi.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on "+env.getProperty("local.server.port") + " port"
        );
        return userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object not Found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
