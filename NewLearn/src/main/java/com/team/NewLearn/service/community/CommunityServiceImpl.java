package com.team.NewLearn.service.community;

import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.mapper.community.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService{


    private final CommunityMapper communityMapper;

    @Override
    public List<CommunityDTO> selectBoardAll(Criteria cri) {
        return communityMapper.selectBoardAll(cri);
    }

    @Override
    public CommunityDTO boardDetail(int id) {
        return communityMapper.boardDetail(id);
    }

    @Override
    public int boardInsert(CommunityDTO communityDTO) {
        return communityMapper.boardInsert(communityDTO);
    }

    @Override
    public int boardUpdate(CommunityDTO CommunityDTO) {
        return communityMapper.boardUpdate(CommunityDTO);
    }

    @Override
    public int boardDelete(int id) {
        return communityMapper.boardDelete(id);
    }

    @Override
    public int getTotal(Criteria cri) {
        return communityMapper.getTotal(cri);
    }
}
