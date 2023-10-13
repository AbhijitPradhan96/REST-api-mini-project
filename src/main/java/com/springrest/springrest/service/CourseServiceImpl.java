package com.springrest.springrest.service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseDao courseDao;


   // List<Courses> list;

    public CourseServiceImpl() {
        // list=new ArrayList<>();
       // list.add(new Courses(145,"Java Core Course","this course contains core java topics"));
       // list.add(new Courses(148,"Spring Boot Course","this course contains spring boot topics"));

    }
    @Override
    public List<Courses> getCourses() {

        return courseDao.findAll();
    }

    @Override
    public Courses getCourses(long courseId) {

    //    Courses c = null;
    //    for (Courses courses: list)
     //   {
       //     if(courses.getId()==courseId)
       //     {
        //        c = courses;
       //         break;
       //     }
      //  }

        return courseDao.getOne(courseId);
    }

    @Override
    public Courses addCourse(Courses courses) {

      //  list.add(courses);
        courseDao.save(courses);

        return courses;
    }

    @Override
    public Courses updateCourse(Courses courses) {

       // list.forEach(e ->{
         //   if(e.getId() == courses.getId()){
             //   e.setTitle(courses.getTitle());
             //   e.setDescription(courses.getDescription());
       //     }
       // });

        courseDao.save(courses);

        return courses;
    }

    @Override
    public void deleteCourse(long parseLong) {
        Courses entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }

    //  @Override
    //public Courses deleteCourse(long courseIdToDelete) {
       // Courses deletedCourse = null;

       // for (Courses course : list) {
         //   if (course.getId() == courseIdToDelete) {
            //    deletedCourse = course;
             //   list.remove(course); // Remove the course from the list
              //  break;
           // }
       // }


       // return deletedCourse; // Return the deleted course (or null if not found)
  //  }



}
