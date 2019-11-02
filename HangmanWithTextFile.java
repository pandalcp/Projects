import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanWithTextFile
{
  public static void main(String[] args) throws FileNotFoundException 
  {
//////////////Reads In the words from a file into a String of Words////////////////////////////////////
	  Scanner scan = new Scanner(new File("Words.txt"));  // scan is the stream for the file
	  String [] wordList = new String [125];

	  //input loop from file Vote.txt
	  for(int i = 0; i < wordList.length; i++)
	  {
		  if(scan.hasNext())
			  wordList[i]=scan.next().toLowerCase();
	  }
	  scan.close(); 
  
/////////////TO HERE/////////////////////////////////
	  int randomWord = (int) (Math.random()*125);
	  int length = wordList[randomWord].length();
	  String [] lines = new String[length];
	  for(int a =0; a<length; a++)
		  lines[a]= "_ ";
	  Scanner s = new Scanner(System.in);
	  System.out.println("Welcome to Hangman!");
	  String oldguesses = "";
	  String word = wordList[randomWord];
	  
	  int b =0;
	  int i=0;
	  while(i<9)
	  {
		//drawings of hangman nooses
		  if(i==0)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      ");
				System.out.println("|  ");
				System.out.println("|      ");
				System.out.println("|    ");
		  }
		  if(i==1)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    ");
				System.out.println("|      ");
				System.out.println("|    ");
		  }
		  
		  if(i==2)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|      |");
				System.out.println("|      |");
				System.out.println("|    ");
		  }
		  if(i==3)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    " + " \\|");
				System.out.println("|      |");
				System.out.println("|    ");
		  }
		  if(i==4)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    " + " \\|/");
				System.out.println("|      |");
				System.out.println("|    ");
		  }
		  if(i==5)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    " + " \\|/");
				System.out.println("|      |");
				System.out.println("|     / ");
		  }
		  if(i==6)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    " + " \\|/");
				System.out.println("|      |");
				System.out.println("|     / \\");
		  }
		  if(i==7)
		  {
			    System.out.println(" -------");
				System.out.println("|      |");
				System.out.println("|      O");
				System.out.println("|    " + " \\|/");
				System.out.println("|      |");
				System.out.println("|    _/ \\");
		  }
		  for(int a=0; a<length; a++)
		  	{
			  	System.out.print(lines[a]);
		  	}
		
		  System.out.println();
		  System.out.println();
		
		  while(i==b)
		  { 
			  System.out.println();
			  System.out.println();
			  System.out.println("Guess a letter.");
		  String guess = s.nextLine();
		  if(word.indexOf(guess)!=(-1))
		  {
			  for(int k=0; k<length; k++)
			  {
				  if(word.substring(k, k+1).equals(guess))
				  {
					  lines[k] = guess + " ";
				  }
			  }
			  for(int a=0; a<length; a++)
			  	{
				  	System.out.print(lines[a]);
			  	}
			  String check = "";
			  for(int c=0; c<length; c++)
			  {
				  if(!lines[c].equals("_ "))
				  {
					  check += "a";
				  }
			  }
			  if(check.length()==length)
			  {
				  System.out.println();
				  System.out.println("Congratulations! You have guessed the word correctly!");
				  i=9;
				
			  }
		  }
		  else
		  {
			  System.out.println("Your letter is not in the word.");
			  oldguesses = oldguesses + " " + guess;
			  System.out.println("Previous guesses: " + oldguesses);
			  System.out.println();
			  if(i==7)
			  {
				    System.out.println(" -------");
					System.out.println("|      |");
					System.out.println("|      O");
					System.out.println("|    " + " \\|/");
					System.out.println("|      |");
					System.out.println("|    _/ \\_");
					
					System.out.println("Sorry, you lose. The correct word was \"" + word + "\".");
					i=9;
			  }
			  
			  b++;
		  }  
	    }
		  i++;
		  
	  }
	}
  }
