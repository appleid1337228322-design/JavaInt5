package ru.project.service;

import org.springframework.stereotype.Service;
import ru.project.dto.UserRequestDto;
import ru.project.dto.UserResponseDto;
import ru.project.model.User;
import ru.project.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public UserResponseDto create(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        User saved = repository.save(user);

        UserResponseDto response = new UserResponseDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setAge(saved.getAge());
        return response;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}