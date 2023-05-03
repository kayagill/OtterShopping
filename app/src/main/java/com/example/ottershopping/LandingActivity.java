package com.example.ottershopping;

import android.content.Context;
import android.content.Intent;

public class LandingActivity {
    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
}
