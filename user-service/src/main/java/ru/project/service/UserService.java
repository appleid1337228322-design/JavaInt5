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

    public List<UserResponseDto> getAll() {
        return repository.findAll().stream().map(user -> {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setAge(user.getAge());
            return dto;
        }).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
