package mobileProgramming.hmhBackend.place.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mobileProgramming.hmhBackend.join.entity.Member;
import mobileProgramming.hmhBackend.place.dto.PlaceDto;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PlaceKey.class)
public class Place {

    @Id
    private Long id;

    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "id")
    private Member member;

    @Column
    private String name;

    @Column
    private String address;

}
