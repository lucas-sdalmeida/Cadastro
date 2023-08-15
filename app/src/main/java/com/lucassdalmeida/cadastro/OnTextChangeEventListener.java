package com.lucassdalmeida.cadastro;

import android.text.Editable;
import android.text.TextWatcher;

public interface OnTextChangeEventListener extends TextWatcher {
    void listen(CharSequence charSequence, int i, int i1, int i2);

    @Override
    default void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    default void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        listen(charSequence, i, i1, i2);
    }

    @Override
    default void afterTextChanged(Editable editable) {

    }
}
