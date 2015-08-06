package com.shopping

import com.shopping.vo.{Apple, FruitItem, Orange}

import scala.collection.JavaConverters._

/**
 * Created by smestry on 05/08/15.
 */
class Checkout {

  private def calculateCost(fruitItems: List[FruitItem] = List()): BigDecimal =
    fruitItems.map(_.price).sum


  def checkoutStep1(fruits: List[String]): BigDecimal = {
    if (fruits == null || fruits.isEmpty) {
      println("Error! Please scan your items again.")
      BigDecimal(0)
    } else {
      val fruitItems = new java.util.ArrayList[FruitItem]()
      fruits.map(f => {
        Option(f.trim.toLowerCase) match {
          case Some("apple") => fruitItems.add(new Apple)
          case Some("orange") => fruitItems.add(new Orange)
          case _ =>
        }
      })
      calculateCost(fruitItems.asScala.toList)
    }
  }
}
