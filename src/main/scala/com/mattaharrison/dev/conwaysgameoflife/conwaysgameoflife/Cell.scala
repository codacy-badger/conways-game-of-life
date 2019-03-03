package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife

import scala.collection.immutable.HashSet

/**
  * Cell structures have a coordinate on the board.
  *
  * @param X x-coordinate on the board.
  * @param Y y-coordinate on the board.
  */
case class Cell(X: Int, Y: Int)

/**
  * Companion object for cells to contain helper logic.
  */
object Cell {
  /**
    * Find the set of neighbours to a given cell, taking into account the edges of the board.
    *
    * @param limitX maximum x-coordinate on the board.
    * @param limitY maximum y-coordinate on the board.
    * @param cell   cell to find the neighbours of.
    *
    * @return set of neighbours.
    */
  def getNeighbours(limitX: Int, limitY: Int)(cell: Cell): Set[Cell] = {
    val xRange = List.range(cell.X - 1, cell.X + 2)
    val yRange = List.range(cell.Y - 1, cell.Y + 2)

    yRange.foldLeft(HashSet[Cell]())((neighbours, y) => {
      xRange.foldLeft(neighbours)((neighboursAcc, x) => {
        if (x == cell.X && y == cell.Y) neighboursAcc
        else if (x < 0 || x > limitX || y < 0 || y > limitY) neighboursAcc
        else neighboursAcc + Cell(x, y)
      })
    })
  }
}