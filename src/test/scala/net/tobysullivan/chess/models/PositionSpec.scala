package net.tobysullivan.chess.models

import org.scalatest.{FlatSpec, Matchers}

class PositionSpec extends FlatSpec with Matchers {
  "+ operand" should "return the expected value when passed a positive Position" in {
    Position(2, 4) + Position(1, 3) shouldBe Position(3, 7)
  }

  it should "return the expected value when passed a negative Position" in {
    Position(3, 5) + Position(-1, -2) shouldBe Position(2, 3)
  }

  it should "return the starting position when passed a Nil Position" in {
    Position(4, 3)+ Position(0, 0) shouldBe Position(4, 3)
  }

  "- operand" should "return the expected value when passed a positive Position" in {
    Position(6, 4) - Position(2, 3) shouldBe Position(4, 1)
  }

  it should "return the expected value when passed a negative Position" in {
    Position(3, 5) - Position(-2, -1) shouldBe Position(5, 6)
  }

  it should "return the starting position when passed a nil Position" in {
    Position(4, 6) - Position(0, 0) shouldBe Position(4, 6)
  }

  "toString" should "return a conventional representation for a valid on-board position" in {
    Position(3, 4).toString shouldBe  "c4"
  }

  it should "return InvalidPosition(x, y) for a position that is off the board to the right" in {
    Position(9, 5).toString shouldBe "InvalidPosition(9, 5)"
  }

  it should "return InvalidPosition(x, y) for a position that is off the board to the left" in {
    Position(9, 5).toString shouldBe "InvalidPosition(9, 5)"
  }

  it should "return InvalidPosition(x, y) for a position that is off the board to the top" in {
    Position(4, 9).toString shouldBe "InvalidPosition(4, 9)"
  }

  it should "return InvalidPosition(x, y) for a position that is off the board to the bottom" in {
    Position(4, 0).toString shouldBe "InvalidPosition(4, 0)"
  }
}
