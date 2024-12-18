package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testTaskDaoFindByName() {
        //Given
        TaskList taskList = new TaskList("list", "lista");

        //When
        taskListDao.save(taskList);
        List<TaskList> result = taskListDao.findByListName("list");

        //Then
       assertEquals(1, result.size());
       assertEquals("lista", result.get(0).getDescription());

        //cleanup
        taskListDao.deleteAll();
    }
}
