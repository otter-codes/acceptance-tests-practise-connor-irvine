package steps

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest._
import support.Browser

class StepDefinitions extends ScalaDsl with EN with Matchers with Browser {

  Given("""^I am on the social care compliance homepage$""") { () =>
    go to "http://localhost:8550/apply-for-social-care-compliance-scheme/capacity-registering"
    find(cssSelector("h1")).get.text shouldBe "Which of these options best describes you?"
  }

  When("""^I click on the 'Social Care Worker' radio button$"""){() =>
    click on id("capacityRegistering.socialCareWorkers")
    click on id("submit")
  }

  Then("""^I should be on the "Social Care Worker" page with a link to advice on the National Living Wage$"""){() =>
    pageTitle shouldBe "Social care workers"

  }
}
