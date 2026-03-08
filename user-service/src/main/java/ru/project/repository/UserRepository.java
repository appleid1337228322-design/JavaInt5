package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
