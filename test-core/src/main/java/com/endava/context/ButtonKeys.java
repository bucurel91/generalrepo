package com.endava.context;

public enum ButtonKeys {
    ADD_BUTTON("addButton"),
    EDIT_BUTTON("editButton"),
    SAVE_BUTTON("saveButton"),
    SEARCH_BUTTON("searchButton"),
    DELETE_BUTTON("deleteButton"),
    SELECT_ALL("checkboxAll"),
    DELETE_CONFIRMATION_BUTTON("dialogDeleteButton");

    private String value;

    ButtonKeys(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
