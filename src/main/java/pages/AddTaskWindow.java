package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import objects.AbstractScreen;
import org.openqa.selenium.By;

public class AddTaskWindow extends AbstractScreen {

    @AndroidFindBy(id = APP_PACKAGE_ID + "/add_task_title")
    private MobileElement taskTitle;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/add_task_description")
    private MobileElement taskDescription;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/fab_edit_task_done")
    private MobileElement taskSaveFavIcon;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/toolbar")
    private MobileElement toolBar;

    public AddTaskWindow(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getTaskTitle() {
        return taskTitle;
    }

    public MobileElement getTaskDescription() {
        return taskDescription;
    }

    public MobileElement getTaskSaveFavIcon() {
        return taskSaveFavIcon;
    }

    public MobileElement getNavBarTitle() {
        return toolBar.findElement(By.className("android.widget.TextView"));
    }

    public MainPage navigateToTodoListScreen() {
        taskSaveFavIcon.click();
        return new MainPage(driver);
    }

    private void addNewTask(String title, String description) {
        MainPage screen = new MainPage(driver);
        final AddTaskWindow addNewToDoTaskScreen = screen.addNewToDoTask();

        addNewToDoTaskScreen.getTaskTitle().sendKeys(title);
        addNewToDoTaskScreen.getTaskDescription().sendKeys(description);
        addNewToDoTaskScreen.navigateToTodoListScreen();
    }
}
