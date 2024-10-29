package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    @Test
    void testAddTaskList(){
        //Given
        Board project = prepareTestData();

        //When

        //Then
        Assertions.assertEquals(3,project.getTaskLists().size());
    }
    @Test
    void testAddTaskListFindUsersTasks(){
    //Given
        Board project = prepareTestData();

    //When
        User user = new User("John8","John Doe");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());

    //Then
    Assertions.assertEquals(2,tasks.size());
    Assertions.assertEquals(user,tasks.get(0).getAssignedUser());
    Assertions.assertEquals(user,tasks.get(1).getAssignedUser());
    }
    @Test
    void testAddTaskListFindOutdatedTasks(){
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .toList();

        //Then
        Assertions.assertEquals(1,tasks.size());
        Assertions.assertEquals("HQLs for analysis",tasks.get(0).getTitle());
    }
    @Test
    void testAddTaskListFindLongTaska() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assertions.assertEquals(2,longTasks);
    }
    @Test
    void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> avgTimeWorkingOnTask = new ArrayList<>();
        avgTimeWorkingOnTask.add(new TaskList("In progress"));
        OptionalDouble averageDays = project.getTaskLists().stream()
                .filter(avgTimeWorkingOnTask::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .mapToLong(task -> ChronoUnit.DAYS.between(task.getCreated(),LocalDate.now()))
                .average();

        //Then
        double expected = 10.0;
        Assertions.assertTrue(averageDays.isPresent());
        Assertions.assertEquals(expected,averageDays.getAsDouble(),0.01);
    }


    private Board prepareTestData() {
        User user1 = new User("John8", "John Doe");
        User user2 = new User("Jane65", "Jane Doe");
        User user3 = new User("Jack7", "Jack Doe");
        User user4 = new User("Jill15", "Jillis Doe");

        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking" + "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis", "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity", "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger", "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching","Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams", "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        project.addTaskList(taskListToDo);

        return project;
    }
}
