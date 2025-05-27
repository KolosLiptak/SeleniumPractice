package org.epam.ui.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.ui.model.User;
import org.epam.ui.page.GmailMainPage;
import org.epam.ui.page.GmailSignInPage;
import org.epam.ui.util.Util;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GmailTest extends AbstractTest{

    private GmailSignInPage gmailSignInPage;
    private GmailMainPage gmailMainPage;

    private User testUser = new User(Util.EMAIL, Util.PASSWORD);

    private static final Logger logger = LogManager.getLogger(GmailTest.class);


    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get(Util.MAIL_URL);
        gmailSignInPage = new GmailSignInPage(driver);
    }


    @Test
    public void signInWithValidCredentials(){
        String expectedText = null;
            enterEmailInfo(testUser.getEmail());
            enterPasswordInfo(testUser.getPassword());
            expectedText = "Labels";
            gmailMainPage = new GmailMainPage(driver);
        Assert.assertEquals(gmailMainPage.getLabelsText(), expectedText);
    }

    public void enterEmailInfo(String email){
        try {
            gmailSignInPage.enterEmail(email);
            gmailSignInPage.clickNextButton();
        } catch (Exception e) {
            logger.error("Entering email failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void enterPasswordInfo(String password){
        try {
            gmailSignInPage.enterPassword(password);
            gmailSignInPage.clickNextButton();
        } catch (Exception e) {
            logger.error("Entering password failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = {"signInWithValidCredentials"})
    public void searchMailNoMatches(){

        String expectedText = "No messages matched your search. Try using search options such as sender, date, size and more.";
        String actualText = gmailMainPage.searchMailNoMatch(Util.INVALID_TEXT);
        Assert.assertEquals(actualText,expectedText);

    }
}
