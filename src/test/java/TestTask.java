
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AddTaskWindow;
import pages.MainPage;
import pages.TaskDetail;

import java.net.MalformedURLException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TestTask extends BaseTest{

    private AddTaskWindow taskWindow;
    private MainPage screen;
    private TaskDetail taskDetail;

    @Before
    public void init(){
        screen = new MainPage(driver);
        taskWindow = screen.addNewToDoTask();
        taskDetail = new TaskDetail(driver);
    }

    @Test
    public void itShouldSaveNewTaskAndDisplayNewTaskList() throws MalformedURLException {
        String title = "Test with Appium";
        String description = "Automation testing";
        taskWindow.getTaskTitle().sendKeys(title);
        taskWindow.getTaskDescription().sendKeys(description);
        final MainPage todoListScreen = taskWindow.navigateToTodoListScreen();
        screen.navigateToTaskDetail();

        assertEquals("TO-DO-MVP", todoListScreen.getNavbarTitle().getText());
        assertNotNull(todoListScreen.getTaskListItems());
        assertEquals(title,taskDetail.getTaskDetailTitle(title));
    }

    @After
    public void shutdown(){
        driver.quit();
    }
}
