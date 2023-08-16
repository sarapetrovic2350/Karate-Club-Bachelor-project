package KarateClub.service;

import KarateClub.iservice.IGroupService;
import KarateClub.iservice.IUserService;
import KarateClub.model.Group;
import KarateClub.model.User;
import KarateClub.repository.IGroupRepository;
import KarateClub.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    private IGroupRepository groupRepository;

    @Autowired
    public GroupService(IGroupRepository groupRepository){
        super();
        this.groupRepository = groupRepository;
    }
    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findByGroupId(id);
    }
}
