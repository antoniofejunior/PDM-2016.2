package pdm.ifpb.webcampdm;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by junior on 11/05/17.
 */

public class HTTPUtils {
    static String conteudo = null;

    public static String acessar(final String endereco){

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(endereco);
                    Log.d("AGDebug", " Chegando aqui 1.0");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //
                    conn.setDoInput(true);
                    conn.setDoOutput(false);
                    conn.setRequestMethod("GET");
                    //
                    InputStream is = conn.getInputStream();
                    Scanner scanner = new Scanner(is);
                    conteudo = scanner.nextLine();
                    //
                    scanner.close();
                    conn.disconnect();

                } catch (Exception e) {
                    conteudo = null;
                }
            }
        };
        //
        Future<String> future = Executors.newSingleThreadScheduledExecutor().submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                runnable.run();
                return conteudo;
            }
        });
        //
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;

    }
}
