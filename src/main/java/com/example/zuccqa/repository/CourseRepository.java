package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 19:12
 * @description:
 */
@Repository
public interface CourseRepository extends MongoRepository<Course, Integer> {
    Course findByCourseId(String courseId);

    List<Course> findByCourseName(String courseName);

    void deleteByCourseId(String courseId);

    @Query(fields = "{'courseId':1}")
    List<Course> findByStudentIdListContains(String studentId);
    @Query(value = "db.getCollection(\"Course\").aggregate([{$lookup:{\n" +
            "    from: \"Feedback\",\n" +
            "    localField: \"_id\",\n" +
            "    foreignField: \"feedbackCourseId\",\n" +
            "    as: \"a\"\n" +
            "}}, {$match:{ '_id':\"625e6c7292db474b15b2a34f\"}}])")
    Object test();

}
