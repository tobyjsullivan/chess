package net.tobysullivan.chess.models.pieces

import net.tobysullivan.chess.models.Position

case class Queen(colour: PieceColour, position: Position, hasMoved: Boolean) extends Piece {
  def legalMoves(attacking: Boolean): Set[Position] = ???

  def move(position: Position, isAttack: Boolean): Piece = ???
}
