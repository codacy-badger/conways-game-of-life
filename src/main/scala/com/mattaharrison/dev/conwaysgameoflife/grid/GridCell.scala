package com.mattaharrison.dev.conwaysgameoflife.grid

import scala.collection.immutable.HashSet

import com.mattaharrison.dev.conwaysgameoflife.Cell

/**
  * Grid cell structures have a coordinate on a 2D board.
  *
  * @param x x-coordinate on the board.
  * @param y y-coordinate on the board.
  */
class GridCell(val x: Int, val y: Int) extends Cell {
  protected val hashCodePrimeBase: Int = 215497
  protected val hashCodePrimeOffset: Int = 46093

  /**
    * Overrides equality checking to validate that the argument is the same cell.
    *
    * @param that cell to compare.
    *
    * @return true if the cell to compare is the same cell.
    */
  override def equals(that: Any): Boolean = {
    that match {
      case gridCell: GridCell =>
        // The same cell
        gridCell.x == this.x && gridCell.y == this.y
      case _ => false
    }
  }

  /**
    * Gets a hash code for this cell.
    *
    * @return an integer hash code.
    */
  override def hashCode: Int = {
    val xHash      = (hashCodePrimeBase  * hashCodePrimeOffset) ^ this.x
    val yHash      = (xHash              * hashCodePrimeOffset) ^ this.y

    yHash
  }

  /**
    * Find the set of neighbours to a given cell.
    *
    * @return set of neighbours.
    */
  def getNeighbours(): Set[Cell] = {
    val xRange = List.range(this.x - 1, this.x + 2)
    val yRange = List.range(this.y - 1, this.y + 2)

    yRange.foldLeft(HashSet[Cell]())((neighbours, y) => {
      xRange.foldLeft(neighbours)((neighboursAcc, x) => {
        if (x == this.x && y == this.y) neighboursAcc
        else neighboursAcc + new GridCell(x, y)
      })
    })
  }
}
