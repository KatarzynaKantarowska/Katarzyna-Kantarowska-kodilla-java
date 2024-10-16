package forum;

import com.kodilla.testing.SimpleUser;
import org.junit.jupiter.api.*;


public class ForumTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }
    @DisplayName("when create SimpleUser with realName, " +
            "then getRealName should return real user name")
    @Test
    public void testCaseRealName(){
        //Given
        SimpleUser simpleUser = new SimpleUser("John_Smith","John Smith");

        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);

        //Then
        Assertions.assertEquals("John Smith", result);
    }
    @DisplayName("when create SimpleUser with name, " +
            "then getUsername should return correct name"
    )


    @Test
    public void testCaseUserName(){
        // Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "The Forum User");

        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
