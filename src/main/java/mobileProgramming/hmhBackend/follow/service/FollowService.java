package mobileProgramming.hmhBackend.follow.service;

import mobileProgramming.hmhBackend.follow.domain.Follow;
import mobileProgramming.hmhBackend.follow.domain.FollowKey;
import mobileProgramming.hmhBackend.follow.domain.FollowRepository;
import mobileProgramming.hmhBackend.follow.dto.FollowDto;
import mobileProgramming.hmhBackend.user.domain.User;
import mobileProgramming.hmhBackend.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FollowService {

    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;


    public List<User> findFollowingList(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent() && !optionalUser.get().getFollows().isEmpty()) {
            List<User> followingList = new ArrayList<>();
            for (Follow f : optionalUser.get().getFollows()) {
                followingList.add(userRepository.findById(f.getFollowingId()).get());
            }
            return followingList;
        } else {
            throw new RuntimeException();
        }
    }


    public void following (FollowDto followDto){
        Optional<User> optionalUser = userRepository.findById(followDto.getId());
        Optional<User> followingUser = userRepository.findById(followDto.getFollowingId());
        if (optionalUser.isPresent() && followingUser.isPresent()) {
            User user = optionalUser.get();
            Follow newFollow = Follow.builder()
                    .user(user)
                    .followingId(followDto.getFollowingId())
                    .build();
            followRepository.save(newFollow);
            user.addFollow(newFollow);
        } else {
            throw new RuntimeException();
        }
    }

    public void unfollow (FollowDto followDto){
        Optional<User> optionalUser = userRepository.findById(followDto.getId());
        Optional<User> unfollowingUser = userRepository.findById(followDto.getFollowingId());
        if (optionalUser.isPresent() && unfollowingUser.isPresent()) {
            User user = optionalUser.get();
            Follow unfollowingData = Follow.builder()
                    .user(user)
                    .followingId(followDto.getFollowingId())
                    .build();
            followRepository.delete(unfollowingData);
        } else {
            throw new RuntimeException();
        }
    }

}
