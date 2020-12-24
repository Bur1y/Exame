package com.bur1y.examen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BookBottomDialog extends BottomSheetDialog  {
    private final StartActivity activity;
    private GoogleMap map;
    private Marker car;

    private View bookOption1;
    private View bookOption2;
    private View bookOption3;
    private Button bookProceed;

    private final Drawable tileBg;
    private final Drawable tileBgSelected;

    public BookBottomDialog(@NonNull Context context, @NonNull GoogleMap map, Marker car) {
        this(context);
        this.map = map;
        this.car = car;
    }

    private BookBottomDialog(@NonNull Context context) {
        super(context);
        activity = (HomeActivity) context;
        tileBg = context.getResources().getDrawable(R.drawable.squ  rcle);
        tileBgSelected = context.getResources().getDrawable(R.drawable.squrcleSelected);

        setContentView(R.layout.activity_book);
        setOnShowListener(dialog -> {
            bookOption1 = findViewById(R.id.min1);
            bookOption1.setOnClickListener(BookBottomDialog.this::onOptionClick);
            bookOption2 = findViewById(R.id.min60);
            bookOption2.setOnClickListener(BookBottomDialog.this::onOptionClick);
            bookOption3 = findViewById(R.id.min1440);
            bookOption3.setOnClickListener(BookBottomDialog.this::onOptionClick);
        });
        setOnDismissListener(d -> {
            car.setIcon(tileBg);
                }

        );
    }


    private void onOptionClick(View v) {
        if (v.getId() == R.id.min1) {
            bookOption1.setBackground(tileBgSelected);
            bookOption2.setBackground(tileBg);
            bookOption3.setBackground(tileBg);
        } else if (v.getId() == R.id.min60) {
            bookOption1.setBackground(tileBg);
            bookOption2.setBackground(tileBgSelected);
            bookOption3.setBackground(tileBg);
        } else if (v.getId() == R.id.min1440) {
            bookOption1.setBackground(tileBg);
            bookOption2.setBackground(tileBg);
            bookOption3.setBackground(tileBgSelected);
        }
    }
}
