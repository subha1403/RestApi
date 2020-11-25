package com.springrest.SpringRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.SpringRestApi.entities.Courses;
import com.springrest.SpringRestApi.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	//get the courses
	@GetMapping("/courses")
	public List<Courses> getCouses()
	{
		return this.courseService.getCourses();
		
	}
	
	//get single course
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) 
	{
		
			return	this.courseService.getCourse(Long.parseLong(courseId));			
	
	}
	
	//put new courses
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) 
	{
		return this.courseService.addCourse(course);
	}
	
	//Update the course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course)
	{
		return this.courseService.updateCourse(course);
	}
	
	//Delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	

}
