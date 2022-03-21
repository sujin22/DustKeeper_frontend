package com.example.dustkeeper;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class FragmentHome extends Fragment {
    @Override
    public void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView string_place = (TextView) view.findViewById(R.id.tv_place);
        ImageView image_cloud = (ImageView) view.findViewById(R.id.image_cloud);
        TextView string_state = (TextView) view.findViewById(R.id.tv_state);
        TextView dustDegree = (TextView) view.findViewById(R.id.tv_dustdegree);
        TextView ult_dustDegree = (TextView) view.findViewById(R.id.tv_ultdustdegree);

        int degree = 36; //DB에서 받아오기
        int ult_degree = 30;//DB에서 받아오기

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
        return view;
    }
}
