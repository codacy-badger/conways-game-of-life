package com.mattaharrison.dev.conwaysgameoflife.grid.finite

import scala.collection.immutable.{HashMap, HashSet}

import com.mattaharrison.dev.conwaysgameoflife.{Board, Cell}

/**
  * Board structures track live cells and upper boundaries on X and Y axis.
  *
  * @param liveCells cells that are alive in the current generation of the board.
  * @param limitX    maximum x-coordinate on board.
  * @param limitY    maximum y-coordinate on board.
  */
class FiniteGridBoard(val liveCells: Set[Cell], val limitX: Int, val limitY: Int) extends Board {
  /**
    * Iterates the current generation of the board to a new generation.
    *
    * @return next generation of the board.
    */
  def iterate(): Board = {
    val liveNeighbourCount = countLiveNeighbours

    val nextGenerationLiveCells =
      findNextGeneration(this.liveCells, liveNeighbourCount)

    new FiniteGridBoard(nextGenerationLiveCells, this.limitX, this.limitY)
  }

  private def countLiveNeighbours(): Map[Cell, Int] =
    this.liveCells.foldLeft(HashMap[Cell, Int]())(
      (liveNeighbourCount, liveCell) =>
        liveCell
          .getNeighbours
          .foldLeft(liveNeighbourCount)((liveNeighbourCountAcc, cell) => {
            if (liveNeighbourCountAcc.contains(cell))
              liveNeighbourCountAcc.updated(cell, liveNeighbourCountAcc(cell) + 1)
            else
              liveNeighbourCountAcc.updated(cell, 1)
          }))

  private def findNextGeneration(currentGenerationLiveCells: Set[Cell],
                                 liveNeighbourCount: Map[Cell, Int]): Set[Cell] =
    liveNeighbourCount.foldLeft(HashSet[Cell]())(
      (nextGenerationLiveCells, liveCellNeighbour) => {
        if (liveCellNeighbour._2 == 3)
          nextGenerationLiveCells + liveCellNeighbour._1
        else if (liveCellNeighbour._2 == 2 && currentGenerationLiveCells.contains(
          liveCellNeighbour._1))
          nextGenerationLiveCells + liveCellNeighbour._1
        else
          nextGenerationLiveCells
      })
}
