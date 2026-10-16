import java.util.*;

class Song {
    String title;
    String artist;

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song other = (Song) obj;
        return title.equalsIgnoreCase(other.title)
                && artist.equalsIgnoreCase(other.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }
}

public class MediaPlayerQueue {
    private LinkedList<Song> playlist = new LinkedList<>();
    private LinkedList<Song> recentHistory = new LinkedList<>();

    public void addSong(Song song) {
        playlist.addLast(song);
        System.out.println("Added: " + song);
    }

    public void addPrioritySong(Song song) {
        playlist.addFirst(song);
        System.out.println("Added to front: " + song);
    }

    public void removeDuplicateSongs() {
        LinkedHashSet<Song> uniqueSongs = new LinkedHashSet<>(playlist);
        playlist.clear();
        playlist.addAll(uniqueSongs);
        System.out.println("Duplicate songs removed.");
    }

    public void playNextSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song song = playlist.removeFirst();
        recentHistory.addFirst(song);
        System.out.println("Now playing: " + song);
    }

    public void showHistory() {
        System.out.println("\nRecent history:");
        if (recentHistory.isEmpty()) {
            System.out.println("No songs played yet.");
            return;
        }

        for (Song song : recentHistory) {
            System.out.println(song);
        }
    }

    public void traverseForwardAndBackward() {
        System.out.println("\nForward traversal:");
        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nBackward traversal:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public void showPlaylist() {
        System.out.println("\nCurrent playlist:");
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();

        player.addSong(new Song("Perfect", "Ed Sheeran"));
        player.addSong(new Song("Believer", "Imagine Dragons"));
        player.addSong(new Song("Perfect", "Ed Sheeran"));
        player.addPrioritySong(new Song("Blinding Lights", "The Weeknd"));

        player.showPlaylist();
        player.removeDuplicateSongs();
        player.showPlaylist();

        player.traverseForwardAndBackward();

        System.out.println("\nPlaying a song...");
        player.playNextSong();
        player.showHistory();
        player.showPlaylist();
    }
}
