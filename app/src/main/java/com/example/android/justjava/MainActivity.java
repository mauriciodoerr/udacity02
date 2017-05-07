package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(77 * 2 + 1);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void modifyQuantity(View view) {
        Integer qtdNumber = 0;
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        TextView price = (TextView) findViewById(R.id.price_text_view);

        if (view == findViewById(R.id.btn_min) && Integer.parseInt(quantity.getText().toString()) > 0) {
            qtdNumber = Integer.parseInt(quantity.getText().toString()) - 1;
        } else if (view == findViewById(R.id.btn_max)){
            qtdNumber = Integer.parseInt(quantity.getText().toString()) + 1;
        }

        quantity.setText(qtdNumber.toString());
        price.setText(setPriceTag(qtdNumber));

    }

    private String setPriceTag(int qtdNumber) {
        int priceTag = qtdNumber * 5;
        return "" + NumberFormat.getCurrencyInstance().format(priceTag);
    }
}