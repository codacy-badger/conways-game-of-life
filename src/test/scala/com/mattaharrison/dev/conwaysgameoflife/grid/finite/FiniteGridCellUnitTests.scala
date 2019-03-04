package com.mattaharrison.dev.conwaysgameoflife.grid.finite

import org.scalatest.{FlatSpec, Matchers}

class FiniteGridCellUnitTests extends FlatSpec with Matchers {
  "Comparing cells for equality" should "return false for different x-coordinates but matching y-coordinates and limits." in {
    val cellA = new FiniteGridCell(0, 2, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different y-coordinates but matching x-coordinates and limits." in {
    val cellA = new FiniteGridCell(1, 0, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different x-limits but matching y-limits and coordinates." in {
    val cellA = new FiniteGridCell(1, 2, 0, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different y-limits but matching x-limits and coordinates." in {
    val cellA = new FiniteGridCell(1, 2, 3, 0)
    val cellB = new FiniteGridCell(1, 2, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different coordinates but matching limits." in {
    val cellA = new FiniteGridCell(0, 2, 3, 4)
    val cellB = new FiniteGridCell(1, 0, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different limits but matching coordinates." in {
    val cellA = new FiniteGridCell(1, 2, 0, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 0)

    cellA should not equal (cellB)
  }

  it should "return false for different x-coordinates and x-limits but matching y-coordinates and y-limits." in {
    val cellA = new FiniteGridCell(0, 2, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 0, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different y-coordinates and y-limits but matching x-coordinates and x-limits." in {
    val cellA = new FiniteGridCell(1, 0, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 0)

    cellA should not equal (cellB)
  }

  it should "return false for different x-coordinates and y-limits but matching y-coordinates and x-limits." in {
    val cellA = new FiniteGridCell(0, 2, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 0)

    cellA should not equal (cellB)
  }

  it should "return false for different y-coordinates and x-limits but matching x-coordinates and y-limits." in {
    val cellA = new FiniteGridCell(1, 0, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 0, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different x-coordinates and limits but matching y-coordinates." in {
    val cellA = new FiniteGridCell(0, 2, 3, 0)
    val cellB = new FiniteGridCell(1, 2, 0, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different y-coordinates and limits but matching x-coordinates." in {
    val cellA = new FiniteGridCell(1, 0, 3, 0)
    val cellB = new FiniteGridCell(1, 2, 0, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different coordinates and x-limits but matching y-limits." in {
    val cellA = new FiniteGridCell(0, 2, 0, 4)
    val cellB = new FiniteGridCell(1, 0, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return false for different coordinates and y-limits but matching x-limits." in {
    val cellA = new FiniteGridCell(0, 2, 3, 0)
    val cellB = new FiniteGridCell(1, 0, 3, 4)

    cellA should not equal (cellB)
  }

  it should "return true for matching coordinates and limits." in {
    val cellA = new FiniteGridCell(1, 2, 3, 4)
    val cellB = new FiniteGridCell(1, 2, 3, 4)

    cellA should equal (cellB)
  }

  it should "return true for reference equal objects." in {
    val cellA = new FiniteGridCell(1, 2, 3, 4)

    cellA should equal (cellA)
  }

  "Getting neighbours of a cell in the middle of the board" should "return all surrounding cells." in {
    val cell = new FiniteGridCell(2, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(1, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(2, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 2, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 2, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(2, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 3, 4, 4))
  }

  it should "return 8 surrounding cells." in {
    val cell = new FiniteGridCell(2, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (8)
  }

  "Getting neighbours of a cell on the left boundary of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(0, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(0, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(0, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 2, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 3, 4, 4))
  }

  it should "return 5 surrounding cells." in {
    val cell = new FiniteGridCell(0, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the bottom boundary of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(2, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(1, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(2, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 4, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 4, 4, 4))
  }

  it should "return 5 surrounding cells." in {
    val cell = new FiniteGridCell(2, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the right boundary of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(4, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(3, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 2, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(4, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(4, 3, 4, 4))
  }

  it should "return 5 surrounding cells." in {
    val cell = new FiniteGridCell(4, 2, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the top boundary of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(2, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(1, 0, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 0, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(2, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 1, 4, 4))
  }

  it should "return 5 surrounding cells." in {
    val cell = new FiniteGridCell(2, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell in the top left corner of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(0, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(1, 0, 4, 4))
    neighbours should contain (new FiniteGridCell(0, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 1, 4, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = new FiniteGridCell(0, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the bottom left corner of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(0, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(0, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(1, 4, 4, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = new FiniteGridCell(0, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the bottom right corner of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(4, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(3, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(4, 3, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 4, 4, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = new FiniteGridCell(4, 4, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the top right corner of the board" should "return all surrounding cells on the board." in {
    val cell = new FiniteGridCell(4, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours should contain (new FiniteGridCell(3, 0, 4, 4))
    neighbours should contain (new FiniteGridCell(3, 1, 4, 4))
    neighbours should contain (new FiniteGridCell(4, 1, 4, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = new FiniteGridCell(4, 0, 4, 4)

    val neighbours = cell.getNeighbours

    neighbours.size should be (3)
  }
}
