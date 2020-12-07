package se.monstermaria.medialibrary;

import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javafx.scene.Scene;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchType;
import se.monstermaria.medialibrary.MediaLibraryApp;

import static org.junit.jupiter.api.Assertions.*;

public class MediaLibraryAppTest  extends JavaFXTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        JavaProfile profile = new JavaProfile(LaunchMode.EMBEDDED);
        profile.setLaunchType(LaunchType.FX_APPLICATION);
        driver = new JavaDriver(profile);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSuccess() {
//        WebElement user = driver.findElement(By.cssSelector("text-field"));
//        WebElement password = driver.findElement(By.cssSelector("password-field"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[text='Login']"));
        assertNotNull(loginButton);
//        user.sendKeys("JavaFX2");
//        password.sendKeys("password");
//        loginButton.click();
//        WebElement messageLabel = driver.findElement(By.id("message"));
//        assertEquals("Congratulations!", messageLabel.getText());
    }

    @Test
    public void loginFail() {
//        WebElement user = driver.findElement(By.cssSelector("text-field"));
//        WebElement password = driver.findElement(By.cssSelector("password-field"));
//        WebElement loginButton = driver.findElement(By.cssSelector("button[text='Log']"));
//        assertEquals(null, loginButton);
        assertThrows(NoSuchElementException.class, () -> driver.findElement(By.cssSelector("button[text='Log']")));
//        user.sendKeys("JavaFX2");
//        password.sendKeys("secret");
//        loginButton.click();
//        WebElement messageLabel = driver.findElement(By.id("message"));
//        assertEquals("Incorrect user or pw.", messageLabel.getText());
    }

    @Override
    protected Scene getScene() {
        MediaLibraryApp stage = new MediaLibraryApp();
        return stage.setupScene();
    }
}
