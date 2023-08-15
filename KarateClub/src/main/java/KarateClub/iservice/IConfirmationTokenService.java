package KarateClub.iservice;

import org.springframework.stereotype.Service;

import KarateClub.model.ConfirmationToken;
import KarateClub.model.User;

@Service
public interface IConfirmationTokenService {
	ConfirmationToken findByConfirmationToken(String confirmationToken);

	ConfirmationToken saveConfirmationToken(User user);
}
