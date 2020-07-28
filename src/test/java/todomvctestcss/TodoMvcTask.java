package todomvctestcss;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTask {

    @Test
    void completedTask(){
        open("http://todomvc.com/examples/emberjs/");

        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();
        elements("#todo-list>li").shouldHave(exactTexts("a" ,"b" ,"c"));

        element("#todo-list>li:nth-of-type(2) .toggle").click();
        elements("#todo-list>li.completed").shouldHave(exactTexts("b"));
        elements("#todo-list>li:not(.completed)").shouldHave(exactTexts("a", "c"));
    }
}
