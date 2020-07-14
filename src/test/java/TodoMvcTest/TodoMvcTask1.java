package TodoMvcTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTask1 {
    @Test

    void completedTask(){

        // open TodoMVC page
        open("http://todomvc.com/examples/emberjs/");

        // add tasks: "a", "b", "c"
        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();

        // tasks should be "a", "b", "c"
        elements("#todo-list>li").shouldHave(exactTexts("a","b","c"));

        // toggle b
        element("#todo-list>li:nth-of-type(2) .toggle").click();

        // completed tasks should be b
        elements("#todo-list>li.completed").shouldHave(exactTexts("b"));

        // active tasks should be a, c
        element("#todo-list>li:nth-of-type(1)").shouldNotHave(Condition.cssClass(".completed"));
        element("#todo-list>li:nth-of-type(3)").shouldNotHave(Condition.cssClass(".completed"));



    }
}
