package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import objects.AbstractScreen;

public class TaskDetail extends AbstractScreen {

    @AndroidFindBy(id = APP_PACKAGE_ID + "/task_detail_title")
    private MobileElement taskDetailTitle;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/task_detail_description")
    private MobileElement taskDetailDescription;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/fab_edit_task")
    private MobileElement taskEditFavIcon;

    @AndroidFindBy(id = APP_PACKAGE_ID + "/task_detail_complete")
    private MobileElement taskDetailComplete;

    public TaskDetail(AppiumDriver driver) {
        super(driver);
    }

    public String getTaskDetailTitle(String title) {
        return taskDetailTitle.getText();
    }
}
