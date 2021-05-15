package com.surabhi.util;

import org.openqa.selenium.support.PageFactory;

public class Page {


    public Page(){
        PageFactory.initElements(TestCaseBase.driver,this);

    }
}
