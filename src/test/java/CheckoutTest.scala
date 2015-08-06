import com.shopping.Checkout
import org.junit.Assert._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by smestry on 05/08/15.
 */
@RunWith(classOf[JUnitRunner])
class CheckoutTest extends FunSuite {

  val sampleCheckout: Checkout = new Checkout

  test("test checkout for step 2 - no items") {
    val basket:List[String] = null
    val cost = sampleCheckout.checkoutStep1(basket)
    assertEquals(cost, BigDecimal(0))
  }

  test("test checkout for step 2 - empty basket") {
    val emptyBasket = List()
    val cost = sampleCheckout.checkoutStep1(emptyBasket)
    assertEquals(cost, BigDecimal(0))
  }

  test("test checkout for step 2 - apples and oranges in the basket") {
    val cart = List("apple","apple","orange","apple")
    val cost = sampleCheckout.checkoutStep1(cart)
    assertEquals(cost, BigDecimal(1.45))
  }

  test("test checkout for step 2 - apples only in the basket") {
    val cart = List("apple","apple"," apple ","apple", " apple")
    val cost = sampleCheckout.checkoutStep1(cart)
    assertEquals(cost, BigDecimal(1.8))
  }

  test("test checkout for step 2 - oranges only in the basket") {
    val cart = List("orange ","orange"," orange ","orange", " orange")
    val cost = sampleCheckout.checkoutStep1(cart)
    assertEquals(cost, BigDecimal(1.0))
  }
}
