package TodoMvcTestXpath;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TodoMvcTask {

    @Test
    void completedTask(){

        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();

        elements(byXpath("//*[@id='todo-list']/li")).shouldHave(exactTexts("a","b","c"));

        element(byXpath("//*[@id='todo-list']/li[2]//*[contains(concat(' ',normalize-space(@class),' '),' toggle ')]")).click();

        elements(byXpath("//*[@id='todo-list']/li[contains(concat(' ',normalize-space(@class),' '),' completed ')]")).shouldHave(exactTexts("b"));

        element(byXpath("//*[@id='todo-list']/li[2]")).shouldNotHave(cssClass(".completed"));
        element(byXpath("//*[@id='todo-list']/li[2]")).shouldNotHave(cssClass(".completed"));



    }


}
