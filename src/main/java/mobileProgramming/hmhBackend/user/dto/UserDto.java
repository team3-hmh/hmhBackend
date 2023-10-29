package mobileProgramming.hmhBackend.user.dto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String birth;
    private String pw;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getPw() {
        return pw;
    }
}
