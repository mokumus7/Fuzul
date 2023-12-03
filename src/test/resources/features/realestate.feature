@realestate
Feature: Fuzul_RealEstate

  @tc01 @smoke
  Scenario: TC01_Search_bar_testing
    Given User goes to "url"
    When User enter "Bahçeli müstakil ev" to ara button
    Then User verifies that results are appears

  @tc02 @smoke
  Scenario: TC02_Minumum_Maximum_Price_Testing
    Given User goes to "url"
    When User enter "2000" to minumum field
    When User enter "10000" to maximum field
    Then User verifies that the price is between 2000 and 10000

  @tc03 @smoke
  Scenario: TC03_Satilik_House_Testing
    Given User goes to "url"
    When User clicks "Satılık" button
    Then User verifies that houeses for "Satılık" are appear

  @tc04 @smoke
  Scenario: TC04_Kiralık_House_Testing
    Given User goes to "url"
    When User clicks "Kiralık" button
    Then User verifies that houeses for "Kiralık" are appear

  @tc05 @smoke
  Scenario: TC05_Gunluk_House_Testing
    Given User goes to "url"
    When User clicks "Günlük" button
    Then User verifies that houeses for "Günlük" are appear

  @tc06 @smoke
  Scenario Outline: TC06_Room_count_testing "<room_count>"
    Given User goes to "url"
    When User chooses "<room_count>"
    Then User verifies that results are correct "<room_count>"
    Examples:
      | room_count |
      | 1 + 1      |
      | 2 + 1      |
      | 3 + 1      |
      | 3 + 2      |
      | 4 + 2      |