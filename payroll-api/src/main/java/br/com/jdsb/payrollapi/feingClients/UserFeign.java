package br.com.jdsb.payrollapi.feingClients;

import br.com.jdsb.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api",url = "http://localhost:8000")
public interface UserFeign {

    @GetMapping(value="/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping(value = "/api/users/")
    ResponseEntity<List<User>> findAll();
}
