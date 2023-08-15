package KarateClub.service;

import KarateClub.iservice.IConfirmationTokenService;
import KarateClub.repository.IConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KarateClub.model.ConfirmationToken;
import KarateClub.model.User;

@Service
public class ConfirmationTokenService implements IConfirmationTokenService {

	private final IConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	public ConfirmationTokenService(IConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}
	
	@Override
	public ConfirmationToken findByConfirmationToken(String confirmationToken) {
		return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
	}

	@Override
	public ConfirmationToken saveConfirmationToken(User user) {
		return confirmationTokenRepository.save(new ConfirmationToken(user));
	}

}
