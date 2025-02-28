Feature: net Bubble LogIn tests
  
  As a Bubble Automation user, I am required to log in so that hackers are kept out.

  @sce001
  Scenario: initialize a new session successfully
    When User enters username as "Juansaintaurautomation@gmail.com" and password as "mLmvqrrhbX0BbsHP1nqwFB7YAecGAkTuYkfOl8gaR34="
    Then The user has been successfully authenticated
