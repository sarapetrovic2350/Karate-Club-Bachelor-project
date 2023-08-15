package KarateClub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.EquipmentStorage;

@Repository
public interface IEquipmentStorageRepository extends JpaRepository<EquipmentStorage, Long>{

}
