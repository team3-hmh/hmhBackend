package mobileProgramming.hmhBackend;

import mobileProgramming.hmhBackend.follow.domain.FollowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FollowRepoTest {

    @Autowired
    FollowRepository followRepository;

    @Test
    public void insertDummies() {

    }
}
