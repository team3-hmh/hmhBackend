package mobileProgramming.hmhBackend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String birth;
    private String pw;
}
