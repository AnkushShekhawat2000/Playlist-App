import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Album arjitAlbum = new Album("Arjit Singh", "Arijit's album");
    Album alanAlbum = new Album("Alen Walker", "Walker's Album" );

    arjitAlbum.addSongToAlbum("Kesaria", 3.5);
    arjitAlbum.addSongToAlbum("Tum kya mile", 4.2);
    arjitAlbum.addSongToAlbum("Lal Ishq", 5.1);

    alanAlbum.addSongToAlbum("Faded",3.5);
    alanAlbum.addSongToAlbum("Alone",4.1);
    alanAlbum.addSongToAlbum("Darkside",2.5);

    LinkedList<Song> myPlaylist = new LinkedList<>();  // myplaylist

   System.out.println(arjitAlbum.addToPlaylistFromAlbum("Kesaria",myPlaylist));
    System.out.println(arjitAlbum.addToPlaylistFromAlbum(2,myPlaylist));
    System.out.println(arjitAlbum.addToPlaylistFromAlbum(5,myPlaylist));

        System.out.println(alanAlbum.addToPlaylistFromAlbum("Alone",myPlaylist));
        System.out.println(alanAlbum.addToPlaylistFromAlbum(3,myPlaylist));


        play(myPlaylist) ;
    }

    private static void play(LinkedList<Song> myPlaylist) {
        if(myPlaylist.size() == 0)
        {
            System.out.println("Your playlist is empty");
            return;
        }

        ListIterator<Song> itr = myPlaylist.listIterator();
        System.out.println("Now Playing:" + itr.next());
        boolean wasNext = true;

        Scanner sc  = new Scanner(System.in);

        printMenu();

        boolean quit =  false;
        while(!quit)
        {
            System.out.println("Please enter your choice");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:

                    break;
                case 2:
                    if(wasNext == false)
                    {
                        itr.next();
                        wasNext = true;
                    }

                    if(!itr.hasNext())
                    {
                        System.out.println("You have reached the end of the playlist");
                    }
                    else
                    {
                        System.out.println("Currently playing" + itr.next());
                        wasNext = true;
                    }
                    break;
                case 3:
                    if(wasNext == true)
                    {
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious())
                    {
                        System.out.println("You are at start of the playlist: ");
                    }
                    else
                    {
                       System.out.println("Currently playing: " + itr.previous());
                       wasNext = false;
                    }
                    break;
                case 4:
                    if(wasNext == true)
                    {
                        System.out.println("Currently playing" +itr.previous());
                        wasNext = false;
                    }
                    else
                    {
                        System.out.println("Currently playing"+itr.next());
                        wasNext = true;
                    }

                    break;
                case 5:
                    break;
                case 6:
                    printsongs(myPlaylist);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter the correct choice");
            }
        }
        return ;
    }

    private static void printsongs(LinkedList<Song> myPlaylist) {

        for(Song song : myPlaylist )
        {
            System.out.println(song);
        }
        return ;
    }

    private static void printMenu() {
        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play the previous song");
        System.out.println("4. Play current song");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all the songs in the playlist");
        System.out.println("7. Quit the application");

    }


}