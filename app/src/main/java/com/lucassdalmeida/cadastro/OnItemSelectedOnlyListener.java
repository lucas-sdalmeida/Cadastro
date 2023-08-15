package com.lucassdalmeida.cadastro;

import android.view.View;
import android.widget.AdapterView;

public interface OnItemSelectedOnlyListener extends AdapterView.OnItemSelectedListener {
    void listen(AdapterView<?> adapterView, View view, int i, long l);

    @Override
    default void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        listen(adapterView, view, i, l);
    }

    @Override
    default void onNothingSelected(AdapterView<?> adapterView) {

    }
}
