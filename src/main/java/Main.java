import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> newPhotos = addPhotoPath();

        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread searchPhoto = new Thread(() -> {
            newPhotos.forEach(autoUploader::onNewPhotoAdded);
        });
        Thread uploadThread = new Thread(() -> autoUploader.startAutoUpload());

        searchPhoto.start();
        uploadThread.start();
    }

    private static List<String> addPhotoPath() {
        List<String> photos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            photos.add("new_photo_133" + (i * 10));
        }
        return photos;
    }
}
