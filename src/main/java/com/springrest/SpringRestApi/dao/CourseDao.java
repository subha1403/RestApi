package com.springrest.SpringRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.SpringRestApi.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{

}
