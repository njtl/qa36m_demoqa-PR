package com.telran.pages.Interactions;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class DroppablePage extends PageBase {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="draggable")
    WebElement draggable;

    @FindBy(id="droppable")
    WebElement droppable;

    public DroppablePage testDroppableHere() {
        Actions actions = new Actions(driver);
        wait(1000);

        actions.dragAndDrop( draggable, droppable ).perform();

        return this;
    }


    public String getDroppedResult() {
        return droppable.getText();
    }

    public DroppablePage testDroppableByOffset() {

        Actions actions = new Actions(driver);

        int xOffSetDraggable = draggable.getLocation().getX();
        int yOffSetDraggable = draggable.getLocation().getY();

        int xOffSetDroppable = droppable.getLocation().getX();
        int yOffSetDroppable = droppable.getLocation().getY();

        int xOffset = (xOffSetDroppable - xOffSetDraggable) +30;
        int yOffset = (yOffSetDroppable - yOffSetDraggable) +30;


        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();

        wait(1000);

        return this;
    }
}
