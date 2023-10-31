package mobileProgramming.hmhBackend.follow.service;

import mobileProgramming.hmhBackend.follow.domain.Follow;
import mobileProgramming.hmhBackend.follow.domain.FollowRepository;
import mobileProgramming.hmhBackend.follow.dto.FollowDto;
import mobileProgramming.hmhBackend.join.entity.Member;
import mobileProgramming.hmhBackend.join.entity.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowService {

    FollowRepository followRepository;
    MemberRepository memberRepository;


    public List<Member> findFollowingList(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent() && !optionalMember.get().getFollows().isEmpty()) {
            List<Member> followingList = new ArrayList<>();
            for (Follow f : optionalMember.get().getFollows()) {
                followingList.add(memberRepository.findById(f.getFollowingId()).get());
            }
            return followingList;
        } else {
            throw new RuntimeException();
        }
    }


    public void following (FollowDto followDto){
        Optional<Member> optionalMember = memberRepository.findById(followDto.getId());
        Optional<Member> followingMember = memberRepository.findById(followDto.getFollowingId());
        if (optionalMember.isPresent() && followingMember.isPresent()) {
            Member member = optionalMember.get();
            Follow newFollow = Follow.builder()
                    .member(member)
                    .followingId(followDto.getFollowingId())
                    .build();
            followRepository.save(newFollow);
            member.addFollow(newFollow);
        } else {
            throw new RuntimeException();
        }
    }

    public void unfollow (FollowDto followDto){
        Optional<Member> optionalMember = memberRepository.findById(followDto.getId());
        Optional<Member> followingMember = memberRepository.findById(followDto.getFollowingId());
        if (optionalMember.isPresent() && followingMember.isPresent()) {
            Member member = optionalMember.get();
            Follow newFollow = Follow.builder()
                    .member(member)
                    .followingId(followDto.getFollowingId())
                    .build();
            followRepository.delete(newFollow);
            member.addFollow(newFollow);
        } else {
            throw new RuntimeException();
        }
    }

}
