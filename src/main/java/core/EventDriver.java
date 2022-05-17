package core;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Slf4j
public class EventDriver implements WebDriverListener {

  @Override
  public void beforeGet(WebDriver driver, String url) {
    log.info("Opening page with URL {}", url);
  }

  @Override
  public void afterGet(WebDriver driver, String url) {
    log.info("Page with URL {} was successfully opened", url);
  }

  @Override
  public void beforeClick(WebElement element) {
    log.info("Clicking on the element {}", element);
  }

  @Override
  public void afterClick(WebElement element) {
    log.info("Clicking on the element {} was successful", element);
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    log.info("Typing [{}] into field {}", keysToSend, element);
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    log.info("Text [{}] was saved at field {}", keysToSend, element);
  }

  @Override
  public void beforeGetText(WebElement element) {
    log.info("Clicking on {}", element);
  }

  @Override
  public void afterGetText(WebElement element, String result) {
    log.info("After clicking on {} appears {}", element, result);
  }
}
