package mobileProgramming.hmhBackend.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mobileProgramming.hmhBackend.follow.domain.Follow;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String birth;
    @Column(nullable = false)
    private String pw;

    @OneToMany(mappedBy = "user")
    private List<Follow> follows;

    public void addFollow(Follow follow) {
        follows.add(follow);
    }
}
