package com.endava.utils;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class ReflectionsUtils {

    public WebElement getWebElementByClass(String fieldName, Class page) throws IllegalAccessException {
        //Class clazz = ScenarioContext.getData(DataKeys.CURRENT_PAGE).getClass();

        WebElement webElement = null;
        Field[] fields = page.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals(fieldName)) {
                webElement = (WebElement) field.get(page);
            }
        }
        return webElement;
    }
}
