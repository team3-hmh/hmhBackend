package mobileProgramming.hmhBackend.posting.service;

import lombok.RequiredArgsConstructor;
import mobileProgramming.hmhBackend.join.entity.Member;
import mobileProgramming.hmhBackend.join.entity.MemberRepository;
import mobileProgramming.hmhBackend.posting.domain.Posting;
import mobileProgramming.hmhBackend.posting.domain.PostingRepository;
import mobileProgramming.hmhBackend.posting.dto.PostingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostingService {

    private final PostingRepository postingRepository;
    private final MemberRepository memberRepository;

    public List<Posting> findAll() {
        return postingRepository.findAll();
    }

    public List<Posting> findByMember(Long member) {
        Optional<Member> optionalMember = memberRepository.findById(member);
        if (optionalMember.isPresent()) {
            return optionalMember.get().getPostings();
        } else {
            throw new RuntimeException();
        }
    }

    public void savePosting(PostingDto postingDto) {
        Optional<Member> optionalMember = memberRepository.findById(postingDto.getMember());
        if (optionalMember.isPresent()) {
            Posting posting = Posting.builder()
                    .id(postingDto.getId())
                    .member(optionalMember.get())
                    .content(postingDto.getContent())
                    .rating(postingDto.getRating())
                    .build();
            postingRepository.save(posting);
            optionalMember.get().addPosting(posting);
        } else {
            Posting posting = Posting.builder()
                    .id(postingDto.getId())
                    .content(postingDto.getContent())
                    .rating(postingDto.getRating())
                    .build();
            postingRepository.save(posting);
        }
    }

    public void deletePosting(PostingDto postingDto) {
        Optional<Posting> deletingPosting = postingRepository.findById(postingDto.getId());
        if (deletingPosting.isPresent()) {
            Posting posting = deletingPosting.get();
            posting.getMember().delPosting(posting);
            postingRepository.delete(posting);
        } else {
            throw new RuntimeException();
        }
    }
}
