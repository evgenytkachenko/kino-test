package lv.iljapavlovs.cucumber.stepdefs;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lv.iljapavlovs.cucumber.enums.TheaterLocation;
import lv.iljapavlovs.cucumber.pageobjects.QuickBookingBar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickBookingSteps {
    private QuickBookingBar quickBookingBar;

    @When("^Quick Booking - user selects session in (\\d+) days$")
    public void userSelectsSessionInDays(int inDays) throws Throwable {
        quickBookingBar.selectSessionInDays(inDays);
    }

    @When("^Quick Booking - user clicks on Buy$")
    public void userClicksOnBuy() throws Throwable {
        quickBookingBar.buy();
    }

    @When("^Quick Booking - user selects any movie with a session in (\\d+) days$")
    public void userSelectsAnyMovieWithASessionInDays(int inDays) throws Throwable {
        quickBookingBar.selectSessionInDays(inDays);
    }

    @When("^Quick Booking - user selects any session$")
    public void userSelectsAnySession() throws Throwable {
        quickBookingBar.selectAnySession();
    }

    @When("^Quick Booking - user selects (ALFA_RIGA|KOSMOS_TALLINN|MEGA_KAUNAS) movie theater$")
    public void userSelectsMovieTheater(String theaterLocation) throws Throwable {
        quickBookingBar.selectTheaterLocation(TheaterLocation.valueOf(theaterLocation));
    }

    @When("^Quick Booking - user selects any movie$")
    public void userSelectsAnyMovie() throws Throwable {
        quickBookingBar.selectAnyMovie();
    }

    @Then("^Quick Booking - is displayed$")
    public void quickBookingIsDisplayed() throws Throwable {
        quickBookingBar = new QuickBookingBar();
        assertThat(quickBookingBar.isPageDisplayed()).isTrue();
    }


}
