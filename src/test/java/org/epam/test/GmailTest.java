package org.epam.test;

import org.epam.page.GmailMainPage;
import org.epam.page.GmailSignInPage;
import org.epam.util.Util;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest extends AbstractTest{

    private GmailSignInPage gmailSignInPage;
    private GmailMainPage gmailMainPage;

    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get(Util.MAIL_URL);
        gmailSignInPage = new GmailSignInPage(driver);
    }


    @Test
    public void signInWithValidCredentials(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        gmailMainPage = gmailSignInPage.login(Util.EMAIL, Util.PASSWORD);

        String expectedText = "Labels";
        Assert.assertEquals(gmailMainPage.getLabelsText(), expectedText);

    }

    @Test(dependsOnMethods = {"signInWithValidCredentials"})
    public void searchMailNoMatches(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String expectedText = "No messages matched your search. Try using search options such as sender, date, size and more.";

        String actualText = gmailMainPage.searchMailNoMatch(Util.INVALID_TEXT);
        Assert.assertEquals(actualText,expectedText);

    }
}
