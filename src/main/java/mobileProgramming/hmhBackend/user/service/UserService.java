package mobileProgramming.hmhBackend.user.service;

import mobileProgramming.hmhBackend.user.domain.User;
import mobileProgramming.hmhBackend.user.domain.UserRepository;
import mobileProgramming.hmhBackend.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException();
        } else {
            User user = optionalUser.get();
            return new UserDto(user.getId(), user.getBirth(), user.getName(), user.getPw());
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addUser(UserDto userDto) {
        User newUser = User.builder()
                        .id(userDto.getId())
                        .name(userDto.getName())
                        .birth(userDto.getBirth())
                        .pw(userDto.getPw())
                        .build();

        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
