package pdm.ifpb.webcampdm.Recover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pdm.ifpb.webcampdm.R;

/**
 * Created by junior on 11/05/17.
 */

public class AdaptadorGravacao extends BaseAdapter {

    private Context contexto;
    private List<GravacaoItem> gravacoes;

    public AdaptadorGravacao(Context contexto, List<GravacaoItem> gravacoes) {
        this.contexto = contexto;
        this.gravacoes = gravacoes;
    }

    @Override
    public int getCount() {
        return gravacoes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return gravacoes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {

        GravacaoItem item = gravacoes.get(posicao);
        LayoutInflater layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.video_item, null);

        // recuperando textview
        TextView idGravacao = (TextView) layout.findViewById(R.id.VIIdCam);
        TextView dataGravacao = (TextView) layout.findViewById(R.id.VIData);
        TextView horaGravacao = (TextView) layout.findViewById(R.id.VIHora);
        // preenchendo textView
        idGravacao.setText(item.getId());
        dataGravacao.setText(item.getDataDia());
        horaGravacao.setText(item.getDataHora());
        //preenchendo o imagemview
        ImageView image = (ImageView) layout.findViewById(R.id.IVImage);
        image.setImageBitmap(item.getSmallImg());

        return layout;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public List<GravacaoItem> getGravacoes() {
        return gravacoes;
    }

    public void setGravacoes(List<GravacaoItem> gravacoes) {
        this.gravacoes = gravacoes;
    }
}
