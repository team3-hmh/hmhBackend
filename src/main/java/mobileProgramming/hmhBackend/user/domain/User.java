package mobileProgramming.hmhBackend.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String birth;
    @Column(nullable = false)
    private String pw;

    public Long getId() { return id; }

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
