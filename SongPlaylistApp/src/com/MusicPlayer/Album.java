package com.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private String name;
	private String artist;
	private ArrayList<Song>songs;
	
	public Album(String name,String artist)
	{
		this.name=name;
		this.artist=artist;
		this.songs=new ArrayList<Song>();
		
	}
	
	public Album()
	{
		
	}
	//findSong method
	public Song findSong(String title)
	{
		for(Song checkedSong : songs)
		{
			if(checkedSong.getTitle().equals(title))
				return checkedSong;
		}
	    return null;  //if song already exist it will return that song or else it will return null
	}
	
	public boolean addSong(String title, double duration)
	{
		
		 //song we are going to add doesn't already exist and it is null
		if(findSong(title) == null)
		{             
	         songs.add(new Song(title,duration));
	         System.out.println(title+" - Successfully added to the list");
	         return true;
		}
		else
		{
			System.out.println("Song with name"+title+"already exist in the list");
			return false;
	    }	
	}
	
		//add song to playlist and it must exist to the arraylist already/album
	public boolean addToPlayList(int trackNumber,LinkedList<Song>PlayList)  //linkedlist to track next & previous song
	{
		int index=trackNumber-1;
		if(index>0 && index<=this.songs.size())
		{
			PlayList.add(this.songs.get(index));
			return true;
			
		}
		System.out.println("this album does not have song with tracknumber"+trackNumber);
		return false;
	}
	
 //create method again with different parameter that takes title of song as i/p 
	public boolean addToPlayList(String title,LinkedList<Song>PlayList)
     {
		for(Song checkedSong:this.songs)
		{
			if(checkedSong.getTitle().equals(title))
			{
			PlayList.add(checkedSong);
			return true;
			
		   }
		}
	  System.out.println(title+"there is no such song in album");
	  return false;
    }
}

