package net.tobysullivan.chess

import net.tobysullivan.chess.models.Position
import net.tobysullivan.chess.models.pieces.{Pawn, Black, White}

object ChessApp extends App {
  for (
    colour <- Set(White, Black);
    x <- 1 to 8;
    y <- 1 to 8;
    attacking <- Set(false, true);
    position = Position(x, y);
    hasMoved = (colour == White && y != 2) || (colour == Black && y != 7);
    pawn = Pawn(colour, position, hasMoved = hasMoved)
  ) yield
    println(s"A $colour pawn at $position which has ${if (hasMoved) "" else "not "}moved and is ${if (attacking) "" else "not "}attacking can move to: ${pawn.legalMoves(attacking)}")

}
