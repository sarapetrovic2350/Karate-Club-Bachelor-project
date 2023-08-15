package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

}
