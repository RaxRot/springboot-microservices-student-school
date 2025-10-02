package com.raxrot.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElse(School.builder().name("NOT FOUND").email("NOT FOUND").build());

        List<Students>students=studentClient.findAllStudentsBySchool(schoolId);//find all students from student microservie

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
