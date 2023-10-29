package mobileProgramming.hmhBackend;

import mobileProgramming.hmhBackend.user.domain.User;
import mobileProgramming.hmhBackend.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,10).forEach(i -> {
            User user = User.builder()
                    .name("testName"+i)
                    .pw("testPw"+i*2)
                    .build();
            userRepository.save(user);
        });
    }

    @Test
    public void findDummiesById() {
        Long id = 10L;

        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            System.out.println("Result: "+user);
        }
    }

    @Test
    public void updateDummies() {
        User user = User.builder()
                .id(10L)
                .name("name updated")
                .birth("birth updated")
                .pw("pw updated")
                .build();
        userRepository.save(user);
    }

    @Test
    public void deleteDummiesById() {
        Long id = 9L;

        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            userRepository.deleteById(id);
        }

    }

}
