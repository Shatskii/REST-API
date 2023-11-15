package com.rest.maximTehnology.repository;

import com.rest.maximTehnology.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDateBetweenAndStatus(Date firsDate, Date lastDate, boolean status);

    List<Task> findByDateAndStatus(Date date, boolean status);
}
