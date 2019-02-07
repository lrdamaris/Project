// The representation of a grid which contains cells.
public class Grid 
{
	private Cell[][] grid;
  private int height, width;

  // Construct a grid.
  public Grid (int requiredHeight, int requiredWidth)
  {
    height = requiredHeight;
    width = requiredWidth;
    grid = new Cell[height][width];
  } // Grid
  
  public void initializeGrid()
  {
    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        grid[i][j] = new Cell();
  } // initializeGrid

  // Makes either cell to come to life, stay at the same state or die.
  /* First if the cell is initially dead, if it has exactly 3 neighbours,
  the method return 1 (i.e. the cell comes to life), otherwise returns 0,
  (i.e. the cell stays dead)*/ 
  public int isAlive (int row, int column, Grid grid)
  {
    int numberOfNeighbours = 0;

    // Counts the number of neighbours of a given cell.
    for (int index_row = row - 1; index_row <= row + 1; index_row++)
    {
      if (index_row >= 0 && index_row < height)
       for (int index_column = column - 1; index_column <= column + 1;
    	      index_column++)
        if (index_column >= 0 && index_column < width)
         if (index_row != row || index_column != column)
      		if (grid.getCell(index_row, index_column).getTypeOfCell() == 1)
      			numberOfNeighbours++;
    } // for
    
    if (grid.getCell(row, column).getTypeOfCell() == 0) // The cell is dead.
    {
      if (numberOfNeighbours == 3)
      	return 1; // Becomes alive.
      else
      	return 0; // Stays dead.
    } // if
    else // The cell is alive.
    {
      if (numberOfNeighbours < 2 || numberOfNeighbours > 3) 
      	return 0; // Becomes dead.
      else
      	return 1; // Stays alive.
    } // else

  } // isAlive 
  
  public void iterate(Grid aGrid, Grid aGridCopy)
  {  
    for (int row = 0; row < height; row++)
    {
    for (int column = 0; column < width; column++)
      {
	// Check if the current cell in the grid is alive or not.
        int typeOfCell = aGrid.isAlive(row, column, aGrid);
       
	// Updates the cell in the copy of the grid accordingly.
	if (typeOfCell == 1)
         aGridCopy.setCell(row, column, 1);
        else
         aGridCopy.setCell(row, column, 0);
      } // for
    } // for

  } // iterate
  
  // Returns a Cell.
  public Cell getCell(int row, int column)
  {
    return this.grid[row][column];
  }
  
  // Sets a cell at the given position and at a given type.
  public void setCell(int row, int column, int typeOfCell)
  {
    this.grid[row][column].setTypeOfCell(typeOfCell);
  }

} // class Grid 
