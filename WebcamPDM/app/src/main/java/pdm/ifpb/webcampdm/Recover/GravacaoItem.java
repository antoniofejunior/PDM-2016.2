package pdm.ifpb.webcampdm.Recover;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by junior on 08/05/17.
 */

public class GravacaoItem implements Serializable {

    private String id;
    private Date data;
    private String caminho;
    private Bitmap smallImg;

    public GravacaoItem(String id, Date data, String caminho, Bitmap smallImg) {
        this.id = id;
        this.data = data;
        this.caminho = caminho;
        this.smallImg = smallImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String path) {
        this.caminho = caminho;
    }

    public Bitmap getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(Bitmap smallImg) {
        this.smallImg = smallImg;
    }

    public String getDataHora(){
        return new SimpleDateFormat("HH:mm").format(data);
    }

    public String getDataDia(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

}
