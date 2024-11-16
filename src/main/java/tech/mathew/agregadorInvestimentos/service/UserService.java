package tech.mathew.agregadorInvestimentos.service;

import org.springframework.stereotype.Service;
import tech.mathew.agregadorInvestimentos.controller.CreatUserDto;
import tech.mathew.agregadorInvestimentos.controller.UpdateUserDto;
import tech.mathew.agregadorInvestimentos.entity.User;
import tech.mathew.agregadorInvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID creatUser(CreatUserDto creatUserDto) {
        //DTO --> entity
        var entity = new User(UUID.randomUUID(),
                creatUserDto.username(),
                creatUserDto.email(),
                creatUserDto.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getId();
    }

    public Optional<User> getUserById(String userId) {

        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto) {

        var id = UUID.fromString(userId);

        var userExists = userRepository.findById(id);

        if (userExists.isPresent()) {
            var user = userExists.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }

            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            userRepository.save(user);
        }
    }

    public void DeleteUserById(String userId) {
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }
    }
}
