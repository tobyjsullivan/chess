package net.tobysullivan.chess.models.pieces

import net.tobysullivan.chess.models.Position
import net.tobysullivan.chess.models.pieces.exceptions.IllegalMoveException
import org.scalatest.{Matchers, FlatSpec}

class QueenSpec extends FlatSpec with Matchers {
  "legalMoves" should "return all valid moves for a white queen in the centre of the board" in {
    val queen = Queen(White, Position(4, 5), hasMoved = true)

    queen.legalMoves(attacking = false) shouldBe Set(
      /* Vertical moves */
      Position(4, 1),
      Position(4, 2),
      Position(4, 3),
      Position(4, 4),
      Position(4, 6),
      Position(4, 7),
      Position(4, 8),
      /* Horizontal moves */
      Position(1, 5),
      Position(2, 5),
      Position(3, 5),
      Position(5, 5),
      Position(6, 5),
      Position(7, 5),
      Position(8, 5),
      /* Diagonal moves */
      Position(1, 4),
      Position(2, 3),
      Position(3, 4),
      Position(6, 7),
      Position(7, 8),
      Position(1, 8),
      Position(2, 7),
      Position(3, 6),
      Position(5, 4),
      Position(6, 3),
      Position(7, 2),
      Position(8, 1)
    )
  }
}
