package com.MusicPlayer;

import java.util.*;

public class Main {
	private static ArrayList<Album>albums=new ArrayList<>();
	public static void main(String[] args) 
	{
		//create obj of album
		
		Album album=new Album("Album1","AC/DC");
		album.addSong("TNT", 4.5);
		album.addSong("Highway to hell", 3.5);
		album.addSong("ThunderStruck", 5.0);
		
		albums.add(album);
		
		 album=new Album("Album2","Eminem");
		album.addSong("Rap god",4.1);
		album.addSong("Not Afraid",3.9);
		album.addSong("Lose Yourself",4.0);
		
		albums.add(album);
		
       LinkedList<Song>PlayList_1=new LinkedList<>();
       albums.get(0).addToPlayList("TNT", PlayList_1);
       albums.get(0).addToPlayList("Highway to hell", PlayList_1);
       albums.get(1).addToPlayList("Rap god", PlayList_1);
       albums.get(1).addToPlayList("Not Afraid", PlayList_1);
        
       //create method to play this above playlist
       play(PlayList_1);
        
	}
	private static void play(LinkedList<Song>PlayList) 
	{
		Scanner sc=new Scanner(System.in);
		boolean quit=false;                    
		boolean forward=true;
		ListIterator<Song>listIterator=PlayList.listIterator();
		
		//check playlist is not empty
		if(PlayList.size()==0)
		{
			System.out.println("This Playlist have no song");
			
		}
		else 
		{
			System.out.println("Now Playing"+listIterator.next().toString());
			printMenu();
		}
		
		//check user is not quit
		while(!quit)
		{
			int action=sc.nextInt();
			sc.nextLine(); //break line
			
			switch(action) //to take care of all actions
			{
			case 0:
				System.out.println("PlayList Complete");
				quit=true;
				break;
				
			case 1:
				if(!forward)
				{
					if(listIterator.hasNext()) {         //to check if next song exist or not
				     listIterator.next();             //if exist shift to next
				}
					forward=true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now Playing"+listIterator.next().toString());
				}
				else
				{
					System.out.println("No song available,reached to the end of the list");
					forward=false;
				}
				break;
			case 2:
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						listIterator.hasPrevious();
					}
					forward=false;
				}
					if(listIterator.hasPrevious()) 
					{
						System.out.println("Now Playing"+listIterator.next().toString());
					}
					else
					{
						System.out.println("We are at first song");
						forward=false;
					}
				
					break;
				
			case 3:
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						System.out.println("Now Playing"+listIterator.previous().toString()); 
					    forward=false;
				    }
					else
					{
						System.out.println("We are at start of the List");
				    }
				}
				else 
				{
			
				if(listIterator.hasNext())
				{
					System.out.println("Now Playing"+listIterator.next().toString());
					forward=true;
			    }
				        else
			            {
				           System.out.println("We have reached at end of the List");
		                }
			   }
		        break;
		        
			case 4:
				printList(PlayList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(PlayList.size()>0)
				{
					if(listIterator.hasNext())
					{
						System.out.println("Now Playing"+listIterator.next().toString());
						
					}
					else
					{
						if(listIterator.hasPrevious())
						{
							System.out.println("Now Playing"+listIterator.previous().toString());
						}
					}
				}
				
			}
		}
	}

	
	private static void printMenu()
	{
		System.out.println("Available options\n press");
		System.out.println("0 - to Quit\n"+
		        "1- to play next song\n"+
				"2- to play previous song\n"+
		        "3- to replay the current song\n"+
				"4- list of all songs\n"+
		        "5- print all available options\n"+
				"6- delete current song");
				
	}
	
	
	private static void printList( LinkedList<Song>PlayList)
	{
		Iterator<Song>iterator=PlayList.iterator();
		System.out.println("=====================");
		
		while(iterator.hasNext())
		{
		 System.out.println(iterator.next());	
		}
		
		System.out.println("=====================");
	}
}
