package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskListDao extends CrudRepository<TaskList, String> {
    List<TaskList> findByListName(String listName);

    List<TaskList> id(int id);
}
