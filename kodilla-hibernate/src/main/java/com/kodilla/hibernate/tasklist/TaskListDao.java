package com.kodilla.hibernate.tasklist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskListDao extends CrudRepository<TaskList, String> {
    List<TaskList> findByListName(String listName);
}
