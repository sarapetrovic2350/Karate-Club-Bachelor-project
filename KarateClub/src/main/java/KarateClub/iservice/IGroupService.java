package KarateClub.iservice;

import KarateClub.model.Group;
import KarateClub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGroupService {
    List<Group> getAllGroups();

    Group findById(Long id);
}
