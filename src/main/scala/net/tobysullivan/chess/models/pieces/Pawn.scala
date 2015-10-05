package net.tobysullivan.chess.models.pieces

import net.tobysullivan.chess.models.Position
import net.tobysullivan.chess.models.pieces.exceptions.IllegalMoveException

case class Pawn(colour: PieceColour, position: Position, hasMoved: Boolean) extends Piece {
  def legalMoves(attacking: Boolean): Set[Position] = {
    val potentialMoves =
      if (attacking)
        legalAttacks
      else
        legalNonAttacks

    potentialMoves.filter(_.isOnBoard)
  }

  private def legalNonAttacks: Set[Position] = {
    hasMoved match {
      case false =>
        for (
          i: Int <- (1 to 2).toSet;
          diff: Position = Position(0, i)
        ) yield {
          if (colour == White) {
            position + diff
          } else {
            position - diff
          }
        }
      case true =>
        val diff = Position(0, 1)
        Set(
          if (colour == White) {
            position + diff
          } else {
            position - diff
          }
        )
    }
  }

  private def legalAttacks: Set[Position] = {
    val potential = for (
      x <- Set(-1, 1);
      diff = Position(x, 1)
    ) yield
      if (colour == White)
        position + diff
      else
        position - diff

    potential.filter(_.isOnBoard)
  }

  def move(position: Position, attacking: Boolean): Piece =
    if (legalMoves(attacking).contains(position))
      if ((colour == White && position.y == 8) || (colour == Black && position.y == 1))
        Queen(colour, position, hasMoved = true)
      else
        this.copy(position = position, hasMoved = true)
    else
      throw IllegalMoveException(this, position)
}
