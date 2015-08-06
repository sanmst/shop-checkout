package com.shopping.vo

/**
 * Created by smestry on 05/08/15.
 */
trait FruitItem extends Serializable {
  val price: BigDecimal
}

class Apple extends FruitItem {
  val price: BigDecimal = BigDecimal(0.60)
}

class Orange extends FruitItem {
  val price: BigDecimal = BigDecimal(0.25)
}
