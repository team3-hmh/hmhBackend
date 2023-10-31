package mobileProgramming.hmhBackend.join.service;

import mobileProgramming.hmhBackend.join.dto.MemberSignInRequestDto;
import mobileProgramming.hmhBackend.join.dto.MemberSignUpRequestDto;

import java.util.Map;


public interface MemberService {

    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;

    public String signIn(MemberSignInRequestDto requestDto) throws Exception;

}
