// Representation of a cell.
public class Cell
{
  private int x_coordinate, y_coordinate, typeOfCell;

  public Cell ()
  {} // Cell
  
  // Constructs a cell - given the required x coodinate and y coordinate.
  public Cell (int requiredXCoordinate, int requiredYCoordinate,
               int requiredTypeOfCell)
  {
    x_coordinate = requiredXCoordinate;
    y_coordinate = requiredYCoordinate;
    typeOfCell = requiredTypeOfCell;
  } // Cell
  
  /* Returns the type of a cell (i.e. 1 or 0, which is alive or 
  dead respectively.*/
  public int getTypeOfCell()
  {
    return typeOfCell;
  }
  
  // Sets the type of the cell.
  public void setTypeOfCell(int requiredTypeOfCell)
  {
    typeOfCell = requiredTypeOfCell;
  }
} // class Cell