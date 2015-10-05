package net.tobysullivan.chess.models.pieces

import net.tobysullivan.chess.models.Position

trait Piece {
  val colour: PieceColour
  val position: Position
  val hasMoved: Boolean

  def legalMoves(attacking: Boolean): Set[Position]

  def move(position: Position, isAttack: Boolean): Piece
}
