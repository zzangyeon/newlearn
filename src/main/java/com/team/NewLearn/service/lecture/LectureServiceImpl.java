package com.team.NewLearn.service.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;
import com.team.NewLearn.mapper.lecture.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureMapper lectureMapper;

    // Lecture list를 가져옴.
    @Override
    public List<LectureDTO> getLectureList() {
        return lectureMapper.getLectureList();
    }

    // 개별 강의 페이지에 정보를 가져옴.
    @Override
    public LectureDTO getLecture(int id) {
        return lectureMapper.getLecture(id);
    }

    // 개별 강의 페이지에서 커리큘럼을 가져옴.
    @Override
    public List<LectureUnitDTO> getLectureUnit(int id) {
        return lectureMapper.getLectureUnit(id);
    }

    @Override
    public int addLecture(LectureDTO lectureDTO) {
        return lectureMapper.addLecture(lectureDTO);
    }


    // 이하 메소드 미구현
    @Override
    public int updateLecture(LectureDTO lectureDTO) {
        return 0;
    }

    @Override
    public int deleteLecture(int id) {
        return 0;
    }

    @Override
    public int addLectureID(String class_id, String uuid) {
        return lectureMapper.addLectureID(class_id,uuid);
    }

    @Override
    public int addFile(AttachFileDTO fileDTO) {
        return lectureMapper.addFile(fileDTO);
    }
}
