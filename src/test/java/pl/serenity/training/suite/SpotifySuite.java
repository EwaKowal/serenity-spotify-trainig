package pl.serenity.training.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.serenity.training.tests.LoginTest;
import pl.serenity.training.tests.PrivacySetupTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        PrivacySetupTest.class
})
public class SpotifySuite {
}
