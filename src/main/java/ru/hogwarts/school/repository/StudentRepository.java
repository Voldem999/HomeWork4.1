package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.entity.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(int age);

    Collection<Student> findAllByAgeBetween(int minAge, int maxAge);

    @Query(value = "select count(*) from students", nativeQuery = true)
    Integer getStudentsCount();

    @Query(value = "select avg(age) from students", nativeQuery = true)
    Double getStudentsAverageAge();

    @Query(value = "select * from students order by id desc limit 5", nativeQuery = true)
    Collection<Student> findLastFiveStudents();
}
