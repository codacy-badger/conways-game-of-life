package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife.grid.finite

import com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife.Cell
import com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife.grid.GridCell

/**
  * Finite grid cell structures have a coordinate on a 2D board bounded by X=0, some upper X limit,
  * Y=0 and some upper Y limit.
  *
  * @param x      x-coordinate on the board.
  * @param y      y-coordinate on the board.
  * @param limitX upper x-axis limit on the board.
  * @param limitY upper y-axis limit on the board.
  */
class FiniteGridCell(x: Int, y: Int, val limitX: Int, val limitY: Int) extends GridCell(x, y) {
  /**
    * Overrides equality checking to validate that the argument is the same cell on the same board.
    *
    * @param that cell to compare.
    *
    * @return true if the cell to compare is the same cell on the same board.
    */
  override def equals(that: Any): Boolean = {
    that match {
      case finiteGridCell: FiniteGridCell =>
        // The same cell
        super.equals(finiteGridCell) &&
        // On the same board
        finiteGridCell.limitX == this.limitX &&
        finiteGridCell.limitY == this.limitY
      case _ => false
    }
  }

  /**
    * Gets a hash code for this cell.
    *
    * @return an integer hash code.
    */
  override def hashCode: Int = {
    val limitXHash = (super.hashCode * hashCodePrimeOffset) ^ this.limitX
    val limitYHash = (limitXHash     * hashCodePrimeOffset) ^ this.limitY

    limitYHash
  }

  /**
    * Find the set of neighbours to a given cell, taking into account the edges of the board.
    *
    * @return set of neighbours.
    */
  override def getNeighbours(): Set[Cell] =
    super
      .getNeighbours
      .map(_.asInstanceOf[GridCell])
      .filterNot(cell => cell.x < 0 || cell.x > this.limitX || cell.y < 0 || cell.y > this.limitY)
      .map(cell => new FiniteGridCell(cell.x, cell.y, this.limitX, this.limitY))
}