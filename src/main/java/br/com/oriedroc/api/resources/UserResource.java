package br.com.oriedroc.api.resources;

import br.com.oriedroc.api.domain.User;
import br.com.oriedroc.api.domain.dto.UserDTO;
import br.com.oriedroc.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok()
                .body(mapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<UserDTO> dtoList = userService.findAll()
                .stream().map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(dtoList);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userService.create(userDTO).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
