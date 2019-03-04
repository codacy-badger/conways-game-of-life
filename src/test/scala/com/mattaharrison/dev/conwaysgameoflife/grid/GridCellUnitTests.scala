package com.mattaharrison.dev.conwaysgameoflife.grid

import org.scalatest.{FlatSpec, Matchers}

class GridCellUnitTests extends FlatSpec with Matchers {
  "Comparing cells for equality" should "return false for different x-coordinates but matching y-coordinates." in {
    val cellA = new GridCell(0, 0)
    val cellB = new GridCell(1, 0)

    cellA should not equal (cellB)
  }

  it should "return false for different y-coordinates but matching x-coordinates." in {
    val cellA = new GridCell(0, 0)
    val cellB = new GridCell(0, 1)

    cellA should not equal (cellB)
  }

  it should "return false for different x-coordinates and different y-coordinates." in {
    val cellA = new GridCell(1, 0)
    val cellB = new GridCell(0, 1)

    cellA should not equal (cellB)
  }

  it should "return true for matching x-coordinates and matching y-coordinates." in {
    val cellA = new GridCell(1, 1)
    val cellB = new GridCell(1, 1)

    cellA should equal (cellB)
  }

  it should "return true for reference equal objects." in {
    val cellA = new GridCell(1, 1)

    cellA should equal (cellA)
  }

  "Getting neighbours of a cell" should "return all surrounding cells." in {
    val cell = new GridCell(0, 0)

    val neighbours = cell.getNeighbours

    neighbours should contain (new GridCell(-1, -1))
    neighbours should contain (new GridCell(0, -1))
    neighbours should contain (new GridCell(1, -1))
    neighbours should contain (new GridCell(-1, 0))
    neighbours should contain (new GridCell(1, 0))
    neighbours should contain (new GridCell(-1, 1))
    neighbours should contain (new GridCell(0, 1))
    neighbours should contain (new GridCell(1, 1))
  }

  it should "return 8 surrounding cells." in {
    val cell = new GridCell(0, 0)

    val neighbours = cell.getNeighbours

    neighbours.size should be (8)
  }
}
