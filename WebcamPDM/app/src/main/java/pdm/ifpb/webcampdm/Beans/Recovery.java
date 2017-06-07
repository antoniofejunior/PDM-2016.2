package pdm.ifpb.webcampdm.Beans;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by junior on 08/05/17.
 */

public class Recovery implements Serializable {
    private String id;
    private String paph;
    private Bitmap thubails;
    private byte[] video;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaph() {
        return paph;
    }

    public void setPaph(String paph) {
        this.paph = paph;
    }

    public Bitmap getThubails() {
        return thubails;
    }

    public void setThubails(Bitmap thubails) {
        this.thubails = thubails;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }
}
