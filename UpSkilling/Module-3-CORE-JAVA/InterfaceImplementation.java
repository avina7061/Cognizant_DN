interface Playable {
    void play();
}

class MusicPlayer implements Playable {
    public void play() {
        System.out.println("Playing music...");
    }
}

class VideoPlayer implements Playable {
    public void play() {
        System.out.println("Playing video...");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        MusicPlayer music = new MusicPlayer();
        music.play();

        VideoPlayer video = new VideoPlayer();
        video.play();
    }
}
