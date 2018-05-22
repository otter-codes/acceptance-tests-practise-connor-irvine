package steps

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import support.Browser

import collection.JavaConverters._


class StepDefinitions extends ScalaDsl with EN with Matchers with Browser {

  Given("""^I am on the social care compliance homepage$""") { () =>
    go to "http://localhost:8550/apply-for-social-care-compliance-scheme/capacity-registering"
    find(cssSelector("h1")).get.text shouldBe "Which of these options best describes you?"
  }

  When("""^I click on the 'Social Care Worker' radio button$""") { () =>
    click on id("capacityRegistering.socialCareWorkers")
    click on id("submit")
  }

  When("""^I click on the 'An agent or representative of a company that employs social care workers' radio button$""") { () =>
    click on id("capacityRegistering.companyAgent")
    click on id("submit")
  }

  When("""^I click on the 'Someone who pays for care directly' radio button$""") { () =>
    click on id("capacityRegistering.personalBudgetHolderDirect")
    click on id("submit")
  }

  Then("""^I should be on the "Social Care Worker" page with a link to advice on the National Living Wage$""") { () =>
    pageTitle shouldBe "Social care workers"

  }


  Then("""^I enter the name of the company as "(.+)" and submit$""") { name: String =>
    textField("value").value = name
    click on id("submit")
  }

  And("""^I click on the 'Yes' radio button and submit$""") { () =>
    radioButtonGroup("value").value = "true"
    click on id("submit")
  }

  Then("""^I enter the company address and submit$""") { (table: DataTable) =>
    table.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach(row => {
      webDriver.findElement(By.name(row.get("Field"))).sendKeys(row.get("Value"))
    })
    click on id("submit")
  }

  And("""^I select 'No' I do not have a UTR and submit$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }

  And("""^I select 'No' I do not have a PAYE ref and submit$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }

  Then("""^I enter my full name as "(.+)" and submit$""") { name: String =>
    textField("value").value = name
    click on id("submit")
  }

  And("""^I select 'Yes' I do have a UK address and submit$""") { () =>
    radioButtonGroup("value").value = "true"
    click on id("submit")
  }

  Then("""^I enter my address and submit$""") { (table: DataTable) =>
    table.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach(row => {
      webDriver.findElement(By.name(row.get("Field"))).sendKeys(row.get("Value"))
    })
    click on id("submit")
  }

  Then("""^I enter my telephone number as "(.+)" and submit$""") { number: String =>
    webDriver.findElement(By.id("value")).sendKeys(number)
    webDriver.findElement(By.id("submit")).click()
  }

  And("""^I select 'No' I do not have an email address and submit$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }
  Then("""^I will be shown my answers and confirm they are correct$""") { () =>
       click on id("submit")
  }
}