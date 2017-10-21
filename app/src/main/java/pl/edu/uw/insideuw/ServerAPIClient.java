package pl.edu.uw.insideuw;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * Created by krzys on 21.10.2017.
 */

public class ServerAPIClient {

    public static String API_ADDRESS = "10.100.25.71";
    public static String API_PORT ="8000";
    private RequestQueue requestQueue;

    public ServerAPIClient(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void setSampleJSON(final TextView textView) {
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET,
                "http://rest-service.guides.spring.io/greeting",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        textView.setText("xd");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.]
                        Log.e("ServerAPI", error.toString());
                    }
                });

        requestQueue.add(arrReq);
        requestQueue.start();
    }

}
