package net.tobysullivan.chess.models.pieces.exceptions

import net.tobysullivan.chess.models.Position
import net.tobysullivan.chess.models.pieces.Piece

case class IllegalMoveException(piece: Piece, position: Position) extends Exception(s"A ${piece.colour} ${piece.getClass.getName} at ${piece.position} cannot move to $position}")
