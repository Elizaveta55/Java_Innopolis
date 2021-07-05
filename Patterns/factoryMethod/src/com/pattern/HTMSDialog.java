package com.pattern;

public class HTMSDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
