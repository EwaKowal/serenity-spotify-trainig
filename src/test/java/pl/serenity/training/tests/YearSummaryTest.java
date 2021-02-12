package pl.serenity.training.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import pl.serenity.training.steps.YearSummarySteps;

@RunWith(SerenityRunner.class)
public class YearSummaryTest extends BaseTest {
    @Steps
    private YearSummarySteps yearSummarySteps;

    //    @Test
    public void showLastYearSummary() {
        yearSummarySteps.showYearSummary();
    }
}
