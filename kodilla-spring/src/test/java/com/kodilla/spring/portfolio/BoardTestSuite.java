package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testTaskAdd() {
        //Given
        String toDoTask = "Task to do";
        String inProgressTask = "Task in progress";
        String doneTask = "Task done";

        //When
        board.getToDoList().addTask(toDoTask);
        board.getInProgressList().addTask(inProgressTask);
        board.getDoneList().addTask(doneTask);

        //Then
        Assertions.assertEquals(1, board.getToDoList().getTasks().size());
        Assertions.assertEquals(1, board.getInProgressList().getTasks().size());
        Assertions.assertEquals(1, board.getDoneList().getTasks().size());
        Assertions.assertEquals(toDoTask, board.getToDoList().getTasks().get(0));
        Assertions.assertEquals(inProgressTask, board.getInProgressList().getTasks().get(0));
        Assertions.assertEquals(doneTask, board.getDoneList().getTasks().get(0));
    }
}
