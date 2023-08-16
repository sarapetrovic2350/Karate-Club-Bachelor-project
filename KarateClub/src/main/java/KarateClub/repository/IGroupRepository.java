package KarateClub.repository;

import KarateClub.model.Group;
import KarateClub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long> {
    Group findByGroupId(Long groupId);
}
