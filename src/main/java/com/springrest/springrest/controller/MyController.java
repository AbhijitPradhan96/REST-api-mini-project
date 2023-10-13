package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Rest(Representational state transfer)
public class MyController {

    //dependencies injection
    @Autowired
    private CourseService courseService;

    //http://localhost:8080/home
    @GetMapping("/home")
    public String home(){
        return "this is the homepage";
    }

    //getting the courses

    //http://localhost:8080/courses(GET method)
    @GetMapping("/courses")
    public List<Courses> getCourses(){

        return this.courseService.getCourses();

    }

    //to get single course
    //http://localhost:8080/courses/courseId
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId){

        return this.courseService.getCourses(Long.parseLong(courseId));

    }

    //add new course
    //http://localhost:8080/courses(POST method)
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses courses){

        return this.courseService.addCourse(courses);

    }


    //update courses
    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses courses){

        return  this.courseService.updateCourse(courses);
    }

    //delete courses
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
