Feature: Privacy setup

Scenario: Turn off Facebook data interaction
    Given Login as 'serenity.test.ek@gmail.com' with password 'RcAZqvHT6AI2lCcK!'
     When Go to privacy settings account options
      And Turn off Facebook data interaction
     Then Check if Facebook data integration is off

Scenario: Turn on Facebook data interaction
    Given Login as 'serenity.test.ek@gmail.com' with password 'RcAZqvHT6AI2lCcK!'
     When Go to privacy settings account options
      And Turn on Facebook data interaction
     Then Check if Facebook data integration is on
