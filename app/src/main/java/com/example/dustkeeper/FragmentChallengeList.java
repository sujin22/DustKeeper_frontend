package com.example.dustkeeper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentChallengeList extends Fragment {
    private LinearLayout ListContainer;
    private ArrayList<String> ChallengeNames;

    @Override
    public void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_list, container, false);

        ListContainer = (LinearLayout) view.findViewById(R.id.challengeListContainer);
        ChallengeNames = new ArrayList<String>();
        ChallengeNames.add("물 마시기");
        ChallengeNames.add("대중교통 이용");
        ChallengeNames.add("자전거 이용");
        ChallengeNames.add("과일 먹기");
        ChallengeNames.add("손 씻기");
        showChallengeList();

        return view;
    }

    void showChallengeList() {
        Toast.makeText(getContext(),ChallengeNames.size(),Toast.LENGTH_SHORT).show();
        for (int i=0; i<ChallengeNames.size(); i++) {

            // 수평 레이아웃 생성
            final LinearLayout ChallengeContainer = new LinearLayout(getContext());
            ChallengeContainer.setOrientation(LinearLayout.HORIZONTAL);

            // 텍스트 뷰 생성
            LinearLayout nameWrapper = new LinearLayout(getActivity());
            TextView nameText = new TextView(getContext());
            nameText.setText(ChallengeNames.get(i));
            nameText.setTextSize(20);
            nameWrapper.addView(nameText);

            // 수평 레이아웃에 텍스트 뷰 추가
            ChallengeContainer.addView(nameWrapper);
        }
    }
}
