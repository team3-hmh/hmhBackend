package mobileProgramming.hmhBackend.follow.controller;

import mobileProgramming.hmhBackend.follow.domain.Follow;
import mobileProgramming.hmhBackend.follow.dto.FollowDto;
import mobileProgramming.hmhBackend.follow.service.FollowService;
import mobileProgramming.hmhBackend.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    FollowService followService;

    /**
     * Select following user list
     * @return following user list
     */
    @GetMapping(value = "/follow/{id}")
    public List<User> followList(@PathVariable Long id) {
        return followService.findFollowingList(id);
    }

    /**
     * follow other user
     */
    @PostMapping(value = "/follow")
    public void followOther(@RequestBody FollowDto followDto){
        followService.following(followDto);
    }

    /**
     * unfollow other user
     */
    @DeleteMapping(value = "/follow")
    public void unfollowOther(@RequestBody FollowDto followDto) {
        followService.unfollow(followDto);
    }
}
