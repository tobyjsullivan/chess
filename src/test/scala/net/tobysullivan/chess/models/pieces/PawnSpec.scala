package net.tobysullivan.chess.models.pieces

import net.tobysullivan.chess.models.Position
import net.tobysullivan.chess.models.pieces.exceptions.IllegalMoveException
import org.scalatest.{Matchers, FlatSpec}

class PawnSpec extends FlatSpec with Matchers {
  "legalMoves" should "return the two valid positions for a white piece which hasn't moved" in {
    val pawn = Pawn(White, Position(3, 2), hasMoved = false)

    pawn.legalMoves(attacking = false) shouldBe Set(Position(3, 3), Position(3, 4))
  }

  it should "return the two valid positions for a black piece which hasn't moved" in {
    val pawn = Pawn(Black, Position(3, 7), hasMoved = false)

    pawn.legalMoves(attacking = false) shouldBe Set(Position(3, 6), Position(3, 5))
  }

  it should "return the one valid position for a white piece which has moved" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    pawn.legalMoves(attacking = false) shouldBe Set(Position(3, 6))
  }

  it should "return the one valid position for a black piece which has moved" in {
    val pawn = Pawn(Black, Position(3, 5), hasMoved = true)

    pawn.legalMoves(attacking = false) shouldBe Set(Position(3, 4))
  }

  it should "return the two valid attacks for a white pawn near the centre of the board" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(2, 6), Position(4, 6))
  }

  it should "return the only valid attack for a white pawn at the left edge of the board" in {
    val pawn = Pawn(White, Position(1, 5), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(2, 6))
  }

  it should "return the only valid attack for a white pawn at the right edge of the board" in {
    val pawn = Pawn(White, Position(8, 5), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(7, 6))
  }

  it should "return the two valid attacks for a black pawn near the centre of the board" in {
    val pawn = Pawn(Black, Position(4, 6), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(3, 5), Position(5, 5))
  }

  it should "return the only valid attack for a black pawn at the left edge of the board" in {
    val pawn = Pawn(Black, Position(1, 5), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(2, 4))
  }

  it should "return the only valid attack for a black pawn at the right edge of the board" in {
    val pawn = Pawn(Black, Position(8, 5), hasMoved = true)

    pawn.legalMoves(attacking = true) shouldBe Set(Position(7, 4))
  }

  "move" should "return a moved white pawn when passed a valid non-attack move" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    pawn.move(Position(3, 6), attacking = false) shouldBe Pawn(White, Position(3, 6), hasMoved = true)
  }

  it should "return a moved black pawn when passed a valid non-attack move" in {
    val pawn = Pawn(Black, Position(3, 5), hasMoved = true)

    pawn.move(Position(3, 4), attacking = false) shouldBe Pawn(Black, Position(3, 4), hasMoved = true)
  }

  it should "return a pawn with hasMoved == true for a previously unmoved pawn" in {
    val pawn = Pawn(White, Position(3, 2), hasMoved = false)

    pawn.move(Position(3, 4), attacking = false) shouldBe Pawn(White, Position(3, 4), hasMoved =  true)
  }

  it should "throw an IllegalMoveException when passed an illegal move" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    a [IllegalMoveException] should be thrownBy {
      pawn.move(Position(3, 4), attacking = false)
    }
  }

  it should "return a white queen when a white pawn is moved to the top of the board" in {
    val pawn = Pawn(White, Position(3, 7), hasMoved = true)

    pawn.move(Position(3, 8), attacking = false) shouldBe Queen(White, Position(3, 8), hasMoved = true)
  }

  it should "return a black queen when a black pawn is moved to the bottom of the board" in {
    val pawn = Pawn(Black, Position(3, 2), hasMoved = true)

    pawn.move(Position(3, 1), attacking = false) shouldBe Queen(Black, Position(3, 1), hasMoved = true)
  }

  it should "throw an IllegalMoveException when passed a position which is a valid attack but invalid move and not attacking" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    a [IllegalMoveException] should be thrownBy {
      pawn.move(Position(4, 6), attacking = false)
    }
  }

  it should "throw an IllegalMoveException when passed a position which is a valid move but invalid attack and attacking" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    a [IllegalMoveException] should be thrownBy {
      pawn.move(Position(3, 6), attacking = true)
    }
  }

  it should "return a white pawn when a white pawn makes a valid attack" in {
    val pawn = Pawn(White, Position(3, 5), hasMoved = true)

    pawn.move(Position(4, 6), attacking = true) shouldBe Pawn(White, Position(4, 6), hasMoved = true)
  }

  it should "return a black queen when a black pawn makes an attack which ends on the bottom row" in {
    val pawn = Pawn(Black, Position(3, 2), hasMoved = true)

    pawn.move(Position(2, 1), attacking =  true) shouldBe Queen(Black, Position(2, 1), hasMoved = true)
  }
}
