package com.team.NewLearn.service.lecture;

import com.team.NewLearn.dto.lecture.AttachFileDTO;
import com.team.NewLearn.dto.lecture.LectureDTO;
import com.team.NewLearn.dto.lectureunit.LectureUnitDTO;

import java.util.List;

public interface LectureService {

    List<LectureDTO> getLectureList();
    //    List<AttachFileDTO> getFile(int id);

    LectureDTO getLecture(int id);

    int addLecture(LectureDTO lectureDTO);

    int addLectureID(String class_id,String uuid);

    int updateLecture(LectureDTO lectureDTO);

    int deleteLecture(int id);

    int addFile(AttachFileDTO fileDTO);

    List<LectureUnitDTO> getLectureUnit(int id);
}
