import com.brainsterSetup.SeleniumSetup;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SeleniumTest {
    @BeforeClass
    public void beforeClass(){
        SeleniumSetup.setup();
    }

    @Test (priority = 1)
    public void testForVerifyingYouReachdTheHomePage(){
        Assert.assertEquals(SeleniumSetup.NavigateToCargodomHomePage(),"http://138.201.81.153:9095/");
    }

    @Test (priority = 2)
    public void testForVerifyingRegistrationForEnduserLookingForTransporterWorks(){
        Assert.assertEquals(SeleniumSetup.enduserLookingForTransporterRegistrationForm(),"Вашиот профил е успешно креиран! Ве молиме проверете го Вашиот e-mail за да ја завршите регистрацијата.");
    }

    @Test (priority = 3)
    public void testForVeifyingThatLogWorks(){
        Assert.assertEquals(SeleniumSetup.logMeIn(),"Angela Bozinovska");
    }

    @Test (priority = 4)
    public void confirmationNewRequest(){
        Assert.assertEquals(SeleniumSetup.newRequest(),"Успешно е креирано ново барање");
    }

    @Test (priority = 5)
    public  void logMeOut() throws InterruptedException {
        Assert.assertEquals(SeleniumSetup.logMeOut(),"http://138.201.81.153:9095/");
    }

    @Test (priority = 6)
    public void iAmTransporterRegistrationVerification(){
        Assert.assertEquals(SeleniumSetup.endUserTransporter(),"Вашиот профил е успешно креиран! Ве молиме проверете го Вашиот e-mail за да ја завршите регистрацијата." );
    }

    @Test (priority = 7)
    public void logMeInAsIamTransporterPlusVerification(){
        Assert.assertEquals(SeleniumSetup.logMeInAsTransporter(),"Активни барања");
    }

    @Test (priority = 8)
    public void makeOffer() {
        Assert.assertEquals(SeleniumSetup.findRequest(), "Понуди за барањето");
    }

    @Test (priority = 9)
    public void navigateToMyOffersPlusVerification(){
        Assert.assertEquals(SeleniumSetup.navigateToMyOffers(),"Вашата понуда е откажана");
    }

    @Test (priority = 10)
    public void clientSupportPlusVerificationMsg(){
        Assert.assertEquals(SeleniumSetup.clientSupport(),"Вашиот меил е успешно испратен до одделот за корисничка поддршка!");
    }

    @AfterClass
    public void afterClass(){
        SeleniumSetup.end();

    }
}
