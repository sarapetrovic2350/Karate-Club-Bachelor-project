package KarateClub.service;

import KarateClub.dto.NewGroupDTO;
import KarateClub.iservice.IGroupService;
import KarateClub.model.*;
import KarateClub.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Group saveGroupWithCoach(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group createGroup(NewGroupDTO newGroupDTO, Coach coach) {
        Group group = new Group();
        group.setGroupName(newGroupDTO.getGroupName());
        group.setGroupCategory(newGroupDTO.getGroupCategory());
        group.setCoach(coach);
        return groupRepository.save(group);
    }
}
