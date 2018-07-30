package com.example.dong.apigit;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class LoadData extends AsyncTask<Void, Void, List<DataOfGit>> {

    private Context mContext;
    private ILoadData mILoadData;
    private List<DataOfGit> mItemGits = new ArrayList<>();

    public LoadData(Context context, ILoadData loadData) {
        this.mContext = context;
        this.mILoadData = loadData;
    }

    @Override
    protected List<DataOfGit> doInBackground(Void... voids) {
        JsonArrayRequest request = new JsonArrayRequest(Constant.URL_PATH,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Convert json array to jsonobject
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject item = response.getJSONObject(i);

                                DataOfGit itemGit = new DataOfGit();
                                itemGit.setName(item.getString(Constant.NAME));
                                itemGit.setFullName(item.getString(Constant.FULL_NAME));
                                itemGit.setUrl(item.getString(Constant.URL));
                                mItemGits.add(itemGit);
                            }
                        } catch (Exception ex) {
                            Log.e(TAG, ex.toString());
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e(TAG, error.toString());
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(request);
        return mItemGits;
    }

    @Override
    protected void onPostExecute(List<DataOfGit> itemGits) {
        super.onPostExecute(itemGits);
        mILoadData.loadData(itemGits);
    }

}
