package KarateClub.service;

import KarateClub.dto.NewGroupDTO;
import KarateClub.iservice.IGroupService;
import KarateClub.model.*;
import KarateClub.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Group> getAllClubGroups(Long clubId) {
        List<Group> allGroups = groupRepository.findAll();
        List<Group> clubGroups = new ArrayList<>();
        for (Group group: allGroups) {
            if(group.getCoach() != null && Objects.equals(group.getCoach().getKarateClub().getClubId(), clubId)) {
                clubGroups.add(group);
            }
        }
        return clubGroups;
    }
    @Override
    public List<Group> getAllGroupsWithoutCoach() {
        List<Group> allGroups = groupRepository.findAll();
        List<Group> groupsWithoutCoach = new ArrayList<>();
        for (Group group: allGroups) {
            if(group.getCoach() == null) {
                groupsWithoutCoach.add(group);
            }
        }
        return groupsWithoutCoach;
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

    @Override
    public Group createGroupWithoutCoach(NewGroupDTO newGroupDTO) {
        Group group = new Group();
        group.setGroupName(newGroupDTO.getGroupName());
        group.setGroupCategory(newGroupDTO.getGroupCategory());
        return groupRepository.save(group);
    }
}
