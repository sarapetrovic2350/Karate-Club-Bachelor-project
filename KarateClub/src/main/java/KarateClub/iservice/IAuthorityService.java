package KarateClub.iservice;

import org.springframework.stereotype.Service;

import KarateClub.model.Authority;

@Service
public interface IAuthorityService {
	Authority findById(Long id);

	Authority findByName(String name);
}
