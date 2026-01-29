package com.ToDo.Repository;

import com.ToDo.Model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    Optional<Task>findByTitleContainingIgnoreCase(String title);

    boolean existsByTitle(String title);


}
