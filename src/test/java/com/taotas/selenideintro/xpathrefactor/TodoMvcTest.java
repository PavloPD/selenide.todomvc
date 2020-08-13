package com.taotas.selenideintro.xpathrefactor;

import com.taotas.selenideintro.common.helpers.Xpath;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void completedTask(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']/li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']/li[.//text()='b']//*["+ Xpath.hasCssClass("toggle") +"]"))
                .click();
        elements(byXpath("//*[@id='todo-list']/li["+ Xpath.hasCssClass("completed") +"]"))
                .shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']/li[not("+ Xpath.hasCssClass("completed") +")]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
