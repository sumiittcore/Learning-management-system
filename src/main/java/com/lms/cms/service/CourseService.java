package com.lms.cms.service;

import com.lms.cms.dto.CourseRequestDto;
import com.lms.cms.entity.Course;
import com.lms.cms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {


   private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(CourseRequestDto course) {
      return courseRepository.save(mapToEntity(course));
      
    }

    private Course mapToEntity(CourseRequestDto dto) {
        Course course = new Course();
        course.setName(dto.name());
        course.setDescription(dto.description());
        course.setPrice(dto.price());
        return course;
    }

    public Course getCourseById(Long id)
    {
       return courseRepository.findById(id).get();
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public Course updateCoursePartially(Long id, CourseRequestDto updatedCourse) {
       Course existingCourse = courseRepository.findById(id).get();
       if (existingCourse.getName() != null) {
           existingCourse.setName(updatedCourse.name());
       }
        if (existingCourse.getDescription() != null) {
            existingCourse.setDescription(updatedCourse.description());
        }
        if (existingCourse.getPrice() != null) {
            existingCourse.setPrice(updatedCourse.price());
        }
        return courseRepository.save(existingCourse);
    }


    public Course updateCourseCompletely(Long id, CourseRequestDto updatedCourse) {
        Course existingCourse = courseRepository.findById(id).get();
        existingCourse.setName(updatedCourse.name());
        existingCourse.setDescription(updatedCourse.description());
        existingCourse.setPrice(updatedCourse.price());
        return courseRepository.save(existingCourse);
    }

    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "Course deleted successfully";
    }
}
