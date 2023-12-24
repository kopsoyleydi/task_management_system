package com.example.taskmanagementsystem.data.repo;


import com.example.taskmanagementsystem.models.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT t FROM Task t where t.author.email = :email")
    List<Task> getTasksByUser(String email);
}
