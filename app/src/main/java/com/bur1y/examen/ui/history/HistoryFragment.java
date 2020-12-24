package com.bur1y.examen.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bur1y.examen.R;

public class HistoryFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //final String[] history = new String[]{"Kia Rio", "15 min", "$15",
               // "Kia Rio", "10 min", "10$", "Kia Rio", "60 min", "50$"};

       // ListView adapter = new ArrayAdapter<String>(getActivity(),
           //     android.R.layout.simple_list_item_1, history);
       // setListAdapter(adapter);
    }
}