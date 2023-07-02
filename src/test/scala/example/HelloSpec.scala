package example

import cats.implicits._

class HelloSpec extends munit.FunSuite {

  test("first test") {
    assertEquals(1, 1)
  }

  test("test wrong usage of Either.catchNonFatal") {
    println("before wrong use of Either.catchNonFatal")
    Either.catchNonFatal(throw new IllegalAccessError("asdf"))
    assertEquals(1, 1)
  }

  test("last test") {
    assertEquals(1, 1)
  }
}
