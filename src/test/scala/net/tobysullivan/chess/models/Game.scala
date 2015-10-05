package net.tobysullivan.chess.models

import net.tobysullivan.chess.models.pieces.{PieceColour, Piece}

case class Game(pieces: Set[Piece], nextTurn: PieceColour)

object Game {

}