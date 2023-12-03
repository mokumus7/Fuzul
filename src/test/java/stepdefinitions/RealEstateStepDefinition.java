package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.waitFor;

public class RealEstateStepDefinition {

    Homepage homepage = new Homepage();

    @Given("User goes to {string}")
    public void user_goes_to(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }


    @When("User enter {string} to ara button")
    public void userEnterToAraButton(String text) {
        homepage.searchBar.sendKeys(text);

    }


    @Then("User verifies that results are appears")
    public void userVerifiesThatResultsAreAppears() {
        int size = homepage.title.size();
        for (int i = 0; i < size; i++) {
            assertTrue(homepage.title.get(i).isDisplayed());
            assertTrue(homepage.title.get(i).getText().equalsIgnoreCase("bahçeli müstakil ev"));
        }

    }

    @When("User enter {string} to minumum field")
    public void userEnterToMinumumField(String min) {
        homepage.min.sendKeys(min);
    }

    @When("User enter {string} to maximum field")
    public void userEnterToMaximumField(String max) {
        homepage.max.sendKeys(max);

    }

    @Then("User verifies that the price is between {int} and {int}")
    public void userVerifiesThatThePriceIsBetweenAnd(int min, int max) {
        int size = homepage.price.size();
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            prices.add(Integer.valueOf(homepage.price.get(i).getText().split(" ")[2]));
        }

        for (Integer w : prices) {
            assertTrue(min < w && w < max);
        }

    }


    @When("User clicks {string} button")
    public void userClicksButton(String text) {
        switch (text) {
            case "Satılık":
                homepage.satilik.click();
                break;
            case "Kiralık":
                homepage.kiralik.click();
                break;
            case "Gunluk":
                homepage.gunluk.click();
                break;

        }


    }


    @Then("User verifies that houeses for {string} are appear")
    public void userVerifiesThatHouesesForAreAppear(String text) {
        switch (text) {
            case "Satılık":
                int size1 = homepage.satilikList.size();
                for (int i = 0; i < size1; i++) {
                    assertEquals(text, homepage.satilikList.get(i).getText().split(" ")[0]);
                }
                break;
            case "Kiralık":
                int size2 = homepage.kiralikList.size();
                for (int i = 0; i < size2; i++) {
                    assertEquals(text, homepage.kiralikList.get(i).getText().split(" ")[0]);
                }
                break;
            case "Günlük":
                int size3 = homepage.gunlukList.size();
                for (int i = 0; i < size3; i++) {
                    assertEquals(text, homepage.gunlukList.get(i).getText().split(" ")[0]);
                }
                break;

        }
    }


    @When("User chooses {string}")
    public void userChooses(String roomCount) {
        switch (roomCount) {
            case "1 + 1":
                homepage.birartibir.click();
                break;
            case "2 + 1":
                homepage.ikiartibir.click();
                break;
            case "3 + 1":
                homepage.ucartibir.click();
                break;
            case "3 + 2":
                homepage.ucartiiki.click();
                break;
            case "4 + 2":
                homepage.dortartiiki.click();
                break;
        }


    }


    @Then("User verifies that results are correct {string}")
    public void userVerifiesThatResultsAreCorrect(String roomCount) {
        switch (roomCount) {
            case "1 + 1":
                int size1 = homepage.birartibirList.size();
                for (int i = 0; i < size1; i++) {
                    String actual = homepage.birartibirList.get(i).getText().split(" ")[0]+" "+
                            homepage.birartibirList.get(i).getText().split(" ")[1]+" "+
                            homepage.birartibirList.get(i).getText().split(" ")[2];
                    assertEquals(roomCount, actual);

                }

                break;
            case "2 + 1":
                int size2 = homepage.ikiartibirList.size();
                for (int i = 0; i < size2; i++) {
                    String actual = homepage.ikiartibirList.get(i).getText().split(" ")[0]+" "+
                            homepage.ikiartibirList.get(i).getText().split(" ")[1]+" "+
                            homepage.ikiartibirList.get(i).getText().split(" ")[2];
                    assertEquals(roomCount, actual);

                }

                break;
            case "3 + 1":
                int size3 = homepage.ucartibirList.size();
                for (int i = 0; i < size3; i++) {
                    String actual = homepage.ucartibirList.get(i).getText().split(" ")[0]+" "+
                            homepage.ucartibirList.get(i).getText().split(" ")[1]+" "+
                            homepage.ucartibirList.get(i).getText().split(" ")[2];
                    assertEquals(roomCount, actual);

                }
                break;
            case "3 + 2":
                int size4 = homepage.ucartiikiList.size();
                for (int i = 0; i < size4; i++) {
                    String actual = homepage.ucartiikiList.get(i).getText().split(" ")[0]+" "+
                            homepage.ucartiikiList.get(i).getText().split(" ")[1]+" "+
                            homepage.ucartiikiList.get(i).getText().split(" ")[2];
                    assertEquals(roomCount, actual);

                }

                break;
            case "4 + 2":
                int size5 = homepage.dortartiikiList.size();
                for (int i = 0; i < size5; i++) {
                    String actual = homepage.dortartiikiList.get(i).getText().split(" ")[0]+" "+
                            homepage.dortartiikiList.get(i).getText().split(" ")[1]+" "+
                            homepage.dortartiikiList.get(i).getText().split(" ")[2];
                    assertEquals(roomCount, actual);

                }
                break;
        }
    }
}