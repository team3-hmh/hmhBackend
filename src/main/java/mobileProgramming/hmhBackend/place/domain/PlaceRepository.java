package mobileProgramming.hmhBackend.place.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, PlaceKey> {
}
