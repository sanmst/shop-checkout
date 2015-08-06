package com.shopping

import com.shopping.vo.{Apple, FruitItem, Orange}

import scala.collection.JavaConverters._

/**
 * Created by smestry on 05/08/15.
 */
class Checkout {

  private def calculateCost(fruitItems: List[FruitItem] = List()): BigDecimal = {
    val apples = fruitItems.filter(f => f.isInstanceOf[Apple])
    val oranges = fruitItems.filter(f => f.isInstanceOf[Orange])

    applyBuyOneGetOneOffer(Option(apples).getOrElse(List())) +
      applyThreeForTwoOffer(Option(oranges).getOrElse(List()))
  }


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

  private def applyBuyOneGetOneOffer(fruitItems: List[FruitItem] = List()): BigDecimal = {
    if (!fruitItems.isEmpty)
      ((fruitItems.size / 2) * fruitItems.head.price) + ((fruitItems.size % 2) * fruitItems.head.price)
    else BigDecimal(0)
  }

  private def applyThreeForTwoOffer(fruitItems: List[FruitItem]= List()): BigDecimal = {
    if (!fruitItems.isEmpty)
      ((fruitItems.size / 3) * 2 * fruitItems.head.price) + ((fruitItems.size % 3) * fruitItems.head.price)
    else BigDecimal(0)
  }
}