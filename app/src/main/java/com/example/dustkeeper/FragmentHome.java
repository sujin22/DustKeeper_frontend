package com.example.dustkeeper;

import static com.example.dustkeeper.retrofit.RetrofitClient.getErrorResponse;
import static com.example.dustkeeper.retrofit.RetrofitClient.getRetrofit;
import static com.example.dustkeeper.retrofit.RetrofitClient.getRetrofitService;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dustkeeper.retrofit.model.ErrorResponse;
import com.example.dustkeeper.retrofit.model.GetPolutionRequest;
import com.example.dustkeeper.retrofit.model.GetPolutionResponse;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    @Override
    public void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
    }

    private int degree;
    private int ult_degree;

    ImageView image_cloud;
    TextView string_state;
    TextView dustDegree;
    TextView ult_dustDegree;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView string_place = (TextView) view.findViewById(R.id.tv_place);
        image_cloud = (ImageView) view.findViewById(R.id.image_cloud);
        string_state = (TextView) view.findViewById(R.id.tv_state);
        dustDegree = (TextView) view.findViewById(R.id.tv_dustdegree);
        ult_dustDegree = (TextView) view.findViewById(R.id.tv_ultdustdegree);

        getPolution();


        return view;
    }

    public void getPolution(){
        getRetrofitService().getPolution("관악구").enqueue(new Callback<GetPolutionResponse>(){
            @Override
            public void onResponse(Call<GetPolutionResponse> call, Response<GetPolutionResponse> response) {
                if(response.isSuccessful()){
                    GetPolutionResponse polutionResponse = response.body();
                    degree = Integer.parseInt(polutionResponse.getDegree());
                    ult_degree = Integer.parseInt(polutionResponse.getUlt_degree());

                    setData();
                    Log.d("HOME", "getPolution / onResponse: Success\n"+ "degree: "+degree+ "  ult_degree: " + ult_degree);
                }else{
                    Log.d("HOME", "getPolution / onResponse: Fail /");
                }
            }

            @Override
            public void onFailure(Call<GetPolutionResponse> call, Throwable throwable) {
                Log.d("HOME", "getPolution / onFailure: "+ throwable.getMessage());
            }
        });
    }
    public void setData(){
        if(degree>=0 && degree<=30){
            image_cloud.setImageDrawable(getResources().getDrawable(R.drawable.cloud_good));
            string_state.setText(R.string.state_good);
        }//좋음

        else if(degree<= 80){
            image_cloud.setImageDrawable(getResources().getDrawable(R.drawable.cloud_normal));
            string_state.setText(R.string.state_normal);
        }//보통

        else if(degree<= 150){
            image_cloud.setImageDrawable(getResources().getDrawable(R.drawable.cloud_bad));
            string_state.setText(R.string.state_bad);
        }//나쁨

        else{
            image_cloud.setImageDrawable(getResources().getDrawable(R.drawable.cloud_verybad));
            string_state.setText(R.string.state_very_bad);
        }//매우 나쁨

        dustDegree.setText(degree + "㎍/m³");
        ult_dustDegree.setText(ult_degree + "㎍/m³");
    }
}
