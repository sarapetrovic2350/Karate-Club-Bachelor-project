package KarateClub.iservice;

import KarateClub.dto.NewGroupDTO;
import KarateClub.dto.UserRegistrationDTO;
import KarateClub.model.Coach;
import KarateClub.model.Group;
import KarateClub.model.Student;
import KarateClub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGroupService {
    List<Group> getAllGroups();
    List<Group> getAllClubGroups(Long clubId);
    List<Group> getAllGroupsWithoutCoach();

    Group findById(Long id);

    Group saveGroupWithCoach(Group group);
    Group createGroup(NewGroupDTO newGroupDTO, Coach coach);
    Group createGroupWithoutCoach(NewGroupDTO newGroupDTO);
}
