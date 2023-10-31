package mobileProgramming.hmhBackend.follow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobileProgramming.hmhBackend.user.domain.User;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowKey implements Serializable {
    private Long user;
    private Long followingId;

}
