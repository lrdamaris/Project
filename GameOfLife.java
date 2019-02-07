/* Program to iterate an initial state of a grid which has its parameters
chosen and entered by the user from the keyboard. Also the user needs to 
enter from the keyboard the number of iterations wanted. The program deals 
with the situation when the user enters negative numbers as the parameters, but
it is assumed that after entering the parameters for the size of the grid, the
elements of the grid will consist if 0s and 1s, 0 representing a dead cell and
1 representing an alive cell. Also it is assumed that the user won't enter 
characters as parameters or elements of the grid and that the grid will be of
the dimensions entered.*/
import java.util.Scanner;

public class GameOfLife 
{ 
  private static int height, width;

  public static void main(String[] args)
  {
    // Test variable for checking if the user insert the right type of data.
    int test;

    // For interaction with the user.
    Scanner inputScanner = new Scanner(System.in);

    System.out.print("Enter the height and the width of the grid: ");
    do
    {  
      test = 0;
      height = inputScanner.nextInt();
      width = inputScanner.nextInt();
      if (height <= 0 || width <= 0)
      {
        test = 1;
        System.out.println("The dimensions of the grid need to be positive " 
                           + "integers");
        System.out.print("Enter the height and the width of the grid: ");
      } // if
    }while (test == 1); 
    
    int numberOfGenerations;
    
    System.out.print("Enter the number of generations wanted in the output: ");

    do
    {
      test = 0;
      numberOfGenerations = inputScanner.nextInt();
      if (numberOfGenerations < 0)
      {
        test = 1;
        System.out.println("The number of generations needs to be greater than "
                           + "or equal to 0");
        System.out.print("Enter the number of generations wanted in the "
                         + "output: ");
      } // if
    }while (test == 1);
    
    Grid seed = new Grid(height, width);
    Grid seedCopy1 = new Grid(height, width);
    seed.initializeGrid();
    seedCopy1.initializeGrid();

    int typeOfCell;
    
    for (int row = 0; row < height; row++)
    {
      for (int column = 0; column < width; column++)
      {
        typeOfCell = inputScanner.nextInt();
        seed.setCell(row, column, typeOfCell);
      } // for 
    } // for

    for (int index = 0; index <= numberOfGenerations; index++)
    {
      if (index == 0)
      {
        System.out.println("Initial state of the game: ");
        printGrid(seed);
        System.out.println();
      } // if
      else if (index == 1)
      {
        System.out.println("First generation: ");
        seed.iterate(seed, seedCopy1);
        printGrid(seedCopy1);
        System.out.println();
      } // else if
      else if (index == 2)
      {
        copyGrid(seed, seedCopy1);
        System.out.println("Second generation: ");
        seed.iterate(seed, seedCopy1);
        printGrid(seedCopy1);
        System.out.println();
      } // else if
      else
      {
        copyGrid(seed, seedCopy1);
        System.out.println(index + "th generation: ");
        seed.iterate(seed, seedCopy1);
        printGrid(seedCopy1);
        System.out.println();
      } // else
    } // for
  
  } // main
  
  // Method to print out a grid.
  private static void printGrid(Grid aGrid)
   {
     for (int row = 0; row < height; row++)
     {
       for (int column = 0; column < width; column++)
        System.out.print(aGrid.getCell(row, column).getTypeOfCell() + " ");
      System.out.println();
     } // for
   } // printGrid
  
  // Method to copy a grid to another grid.
  private static void copyGrid(Grid copyGrid, Grid aGrid)
  {
    for (int row = 0; row < height; row++)
    {
      for (int column = 0; column < width; column++)
      {
       copyGrid.setCell(row, column, aGrid.getCell(row,column).getTypeOfCell());
      } // for 
    } // for
  } // copyGrid

} // class GameOfLife