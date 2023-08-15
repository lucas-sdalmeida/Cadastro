package com.lucassdalmeida.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lucassdalmeida.cadastro.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private final Form form = new Form();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        setUpListeners();
    }

    private void setUpListeners() {
        setUpNameFieldListener();
        setUpPhoneNumberListener();
        setUpEmailFieldListener();
        setUpEmailCheckboxListener();
        setUpCityFieldListener();
        setUpUfSelectionListener();
        setUpGenderRadioListener();
        setUpRegistryButtonListener();
        setUpResetButtonListener();
    }

    private void setUpResetButtonListener() {
        activityMainBinding.resetButton
                .setOnClickListener(view -> {
                    form.resetFields();
                    clearInputs(activityMainBinding);
                });
    }

    private void setUpRegistryButtonListener() {
        activityMainBinding.registryButton
                .setOnClickListener(view -> {
                    String message = "Alguns campos necessários não foram preenchidos!";

                    if (form.hasAllFieldFilled())
                        message = form.toString();

                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                });
    }

    private void setUpGenderRadioListener() {
        activityMainBinding.genderRadio.setOnCheckedChangeListener((radioGroup, i) -> {
            if (radioGroup.findViewById(i) == null)
                return;
            String gender = ((RadioButton) radioGroup.findViewById(i)).getText().toString();
            form.setGender(gender);
        });
    }

    private void setUpUfSelectionListener() {
        activityMainBinding.ufSelection
            .setOnItemSelectedListener((OnItemSelectedOnlyListener) (adapterView, view, i, l) -> {
                form.setUf(((TextView)view).getText().toString());
            });
    }

    private void setUpCityFieldListener() {
        activityMainBinding.cityField
                .addTextChangedListener((OnTextChangeEventListener) (charSequence, i, i1, i2) -> {
                    form.setCity(charSequence.toString());
                });
    }

    private void setUpEmailCheckboxListener() {
        activityMainBinding.emailCheckbox
                .setOnCheckedChangeListener((compoundButton, b) -> {
                    form.setAddEmailToList(compoundButton.isChecked());
                });
    }

    private void setUpEmailFieldListener() {
        activityMainBinding.emailField
                .addTextChangedListener((OnTextChangeEventListener) (charSequence, i, i1, i2) -> {
                    form.setEmail(charSequence.toString());
                });
    }

    private void setUpPhoneNumberListener() {
        activityMainBinding.phoneNumberField
                .addTextChangedListener((OnTextChangeEventListener) (charSequence, i, i1, i2) -> {
                    form.setPhoneNumber(charSequence.toString());
                });
    }

    private void setUpNameFieldListener() {
        activityMainBinding.nameField
                .addTextChangedListener((OnTextChangeEventListener) (charSequence, i, i1, i2) -> {
                    form.setName(charSequence.toString());
                });
    }

    private void clearInputs(ActivityMainBinding activityMainBinding) {
        activityMainBinding.nameField.setText("");
        activityMainBinding.phoneNumberField.setText("");
        activityMainBinding.emailField.setText("");
        activityMainBinding.emailCheckbox.setChecked(false);
        activityMainBinding.genderRadio.clearCheck();
        activityMainBinding.cityField.setText("");
    }
}