package example

import cats.implicits._

class HelloSpec extends munit.FunSuite {

  test("test wrong usage of Either") {

    Either.catchNonFatal(throw new IllegalAccessError("asdf"))
    assertEquals(1, 1)
  }
}
