package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.onlinegroceriesapp.R;

public class Error extends AppCompatActivity {
    Button try_again;
    TextView back_to_home;
    ImageView exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);

        CardView layoutGet = findViewById(R.id.Card_error);
        ViewGroup.LayoutParams layoutParams = layoutGet.getLayoutParams();
        int width = layoutParams.width;

        getWindow().setLayout(width, ListPopupWindow.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        ViewGroup root = (ViewGroup) getWindow().getDecorView().getRootView();
        applydim(root);

        try_again = findViewById(R.id.try_again);
        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Error.this, MyCart.class);
                startActivity(intent);
            }
        });
        back_to_home=findViewById(R.id.Back_to_home);
        back_to_home.setOnClickListener(view -> {
            Intent intent = new Intent(Error.this,HomeScreen.class);
            startActivity(intent);
        });
        exit=findViewById(R.id.exit);
        exit.setOnClickListener(view -> {
            finish();
        });
    }

    private static void applydim(ViewGroup parent) {
        Drawable dim = new ColorDrawable(Color.TRANSPARENT);
        dim.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        dim.setAlpha(200);
        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.add(dim);
    }
}
