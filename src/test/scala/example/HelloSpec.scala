package example

import example.MockData.{Coord, unexpectedJsonString, validJsonString}
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import cats.implicits._

class HelloSpec extends munit.FunSuite {
  test("test with valid mock data") {
    println("Hello from inside 'test with valid mock data'")

    val coords =
      io.circe.parser
        .decode[List[Coord]](validJsonString)
        .toOption
        .get
        .toNel
        .get

    println("Goodbye from inside 'test with valid mock data'")

    assertEquals(coords.toList, List(Coord(1, 2)))

  }

  test("test with broken mock data") {
    println("Hello from inside 'test with broken mock data'")


    val coords =
      io.circe.parser
        .decode[List[Coord]](unexpectedJsonString)
        .toOption
        .get
        .toNel
        .get

    println("Goodbye from inside 'test with broken mock data'")

    assertEquals(coords.toList, List(Coord(1, 2)))
  }

  test("throwing IllegalAccessError") {
    throw new IllegalAccessError("asdf")
  }
}

object MockData {

  case class Coord(x: Int, y: Int)

  object Coord {
    implicit val decoder: Decoder[Coord] = deriveDecoder
  }

  val validJsonString =
    """
       [
         { "x": 1, "y": 2 }
       ]
    """

  val unexpectedJsonString =
    """
     [
       { "entry":  { "x": 1, "y": 2 } }
     ]
  """

}
