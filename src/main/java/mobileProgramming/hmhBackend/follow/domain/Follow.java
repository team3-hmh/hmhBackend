package mobileProgramming.hmhBackend.follow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mobileProgramming.hmhBackend.user.domain.User;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(FollowKey.class)
public class Follow {

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @Id
    private Long followingId;


}
