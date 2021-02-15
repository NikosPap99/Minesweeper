import java.util.Scanner;
import java.util.Random;

class Board
{
	private String[][] initialBoard;
	private String[][] playerBoard;
	private int dimension;
	private int mines;
	
	public Board(int dimension)
	{
		this.dimension=dimension;
		initialBoard=new String[dimension][dimension];
		playerBoard=new String[dimension][dimension];
		createMinefield(dimension);
	}
	
	private void createMinefield(int dimension)
	{
		mines=(dimension*dimension)/3;
		
		for(int i=0;i<mines;i++)
		{
			Random randomGenerator=new Random();
			int x=randomGenerator.nextInt(dimension);
			int y=randomGenerator.nextInt(dimension);
			
			if(initialBoard[x][y]=="X")
			{
				while(initialBoard[x][y]=="X")
				{
					x=randomGenerator.nextInt(dimension);
					y=randomGenerator.nextInt(dimension);
				}
			}
			
			initialBoard[x][y]="X";
		}
	}
	
	public int getMines()
	{
		return mines;
	}

	public int getDimension() {
		return dimension;
	}
	
	public String[][] getInitialBoard()
	{
		return initialBoard;
	}
	
	public void getSafeHit(int[] array)
	{
		int x=array[0];
		int y=array[1];
		playerBoard[x][y]="O";
	}
	
	public void getRiskyHit(int[] array)
	{
		int x=array[0];
		int y=array[1];
		int minesSum=0;
		
		if(x>0 && y>0)
		{
			if(x<dimension-1 && y<dimension-1)
			{
				for(int i=x-1;i<x+2;i++)
				{
					for(int j=y-1;j<y+2;j++)
					{
						if(initialBoard[i][j]=="X")
						{
							minesSum++;
						}
					}
				}
			}
			
			else
			{
				if(x==dimension-1 && y!=dimension-1)
				{
					for(int i=y-1;i<y+2;i++)
					{
						if(initialBoard[x-1][i]=="X")
						{
							minesSum++;
						}
					}
					
					if(initialBoard[x][y-1]=="X")
					{
						minesSum++;
					}
					
					if(initialBoard[x][y+1]=="X")
					{
						minesSum++;
					}
				}
				
				if(x!=dimension-1 && y==dimension-1)
				{
					for(int i=x-1;i<x+2;i++)
					{
						if(initialBoard[i][y-1]=="X")
						{
							minesSum++;
						}
					}
					
					if(initialBoard[x-1][y]=="X")
					{
						minesSum++;
					}
					
					if(initialBoard[x+1][y]=="X")
					{
						minesSum++;
					}
				}
				
				if(x==dimension-1 && y==dimension-1)
				{
					if(initialBoard[x][y-1]=="X")
					{
						minesSum++;
					}
					
					if(initialBoard[x-1][y]=="X")
					{
						minesSum++;
					}
					
					if(initialBoard[x-1][y-1]=="X")
					{
						minesSum++;
					}
				}
			}
		}
		
		if(x==0 && y>0)
		{
			if(y!=dimension-1)
			{
				for(int i=y-1;i<y+2;i++)
				{
					if(initialBoard[x+1][i]=="X")
					{
						minesSum++;
					}
				}
				
				if(initialBoard[x][y-1]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x][y+1]=="X")
				{
					minesSum++;
				}
			}
			
			else
			{
				if(initialBoard[x][y-1]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x+1][y-1]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x+1][y]=="X")
				{
					minesSum++;
				}
			}
		}
		
		if(y==0 && x>0)
		{
			if(x!=dimension-1)
			{
				for(int i=x-1;i<x+2;i++)
				{
					if(initialBoard[i][y+1]=="X")
					{
						minesSum++;
					}
				}
				
				if(initialBoard[x-1][y]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x+1][y]=="X")
				{
					minesSum++;
				}
			}
			
			else
			{
				if(initialBoard[x-1][y]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x-1][y+1]=="X")
				{
					minesSum++;
				}
				
				if(initialBoard[x][y+1]=="X")
				{
					minesSum++;
				}
			}
		}
		
		if(x==0 & y==0)
		{
			if(initialBoard[x+1][y+1]=="X")
			{
				minesSum++;
			}
			
			if(initialBoard[x][y+1]=="X")
			{
				minesSum++;
			}
			
			if(initialBoard[x+1][y]=="X")
			{
				minesSum++;
			}
		}
		
		playerBoard[x][y]=""+minesSum;
	}
	
	public void printPlayerBoard()
	{
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
			{
				if(playerBoard[i][j]==null)
				{
					System.out.print(" "+"|");
				}
				
				else
				{
					System.out.print(playerBoard[i][j]+"|");
				}
			}
			System.out.println();
		}
	}
	
	public void printInitialBoard()
	{
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
			{
				if(initialBoard[i][j]==null)
				{
					System.out.print(" "+"|");
				}
				
				else
				{
					System.out.print(initialBoard[i][j]+"|");
				}
			}
			System.out.println();
		}
	}

	public String[][] getPlayerBoard() {
		return playerBoard;
	}
}

class Player
{
	private Board board;
	private String[][] initialBoard;
	private int points;
	private String name;
	
	public Player(String name,Board board,int dimension)
	{
		this.board=board;
		this.name=name;
		this.initialBoard=board.getInitialBoard();
		this.points = dimension * dimension / 3;
		System.out.println("Welcome to the Minesweeper game, "+name+"! If you flag a mine correctly, then 1 point is added to your score, whereas if you flag a safe block, then you get -1 of your score.\nO: Flagged block\nX: Block with mine\nIt's time for you to make your first move, so good luck.");
		System.out.println("Type in 'F' for flag move or 'R' for risky move, then type in the coordinates of the block you wish to hit:");
	}

	private boolean boardCompleted() {
		int d = board.getDimension();
		String[][] playerBoard = board.getPlayerBoard();

		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				if(playerBoard[i][j] == null && initialBoard[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void printFinalBoard() {
		int d = board.getDimension();
		String[][] playerBoard = board.getPlayerBoard();

		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				if(initialBoard[i][j] != null) {
					System.out.print(initialBoard[i][j]+"|");
				}
				else {
					if(playerBoard[i][j] == null) {
						System.out.print(" |");
					}
					else {
						System.out.print(playerBoard[i][j]+"|");
					}
				}
			}
			System.out.println("");
		}
	}
	
	public boolean move()
	{
		Scanner keyboard=new Scanner(System.in);
		String moveType=keyboard.next();
		int x=keyboard.nextInt();
		int y=keyboard.nextInt();
		int[] block={x,y};
		
		if(moveType.equals("F"))
		{
			if(initialBoard[x][y]=="X")
			{
				points++;
				board.getSafeHit(block);
			}
			
			else
			{
				points--;
				board.getSafeHit(block);
			}
		}
		
		if(moveType.equals("R"))
		{
			if(initialBoard[x][y]=="X")
			{
				System.out.println("You just hit a mine! Game over...");
				return true;
			}
			
			else
			{
				board.getRiskyHit(block);
			}
		}

		if(boardCompleted() == true) {
			System.out.println("You completed the game without detonating any mines! You score is: " + points);
			return true;
		}
		return false;
	}
}
	
	

class Minesweeper
{
	public static void main(String[] args)
	{
		boolean gameIsOver=false;
		Board board=new Board(10);
		Player player=new Player("Nick",board,10);
		//board.printInitialBoard(); used for testing

		while(true)
		{
			System.out.println("");
			gameIsOver=player.move();
			if(gameIsOver) {
				break;
			}
			board.printPlayerBoard();
		}

		System.out.println();
		player.printFinalBoard();
	}
}
		
	