package ru.mirea.kuzin.mireaproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.kuzin.mireaproj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.calculateFragment,R.id.webViewFragment,R.id.musicPlayer)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void OnClick1(View view) {
        EditText element1 = findViewById(R.id.Num1);
        EditText element2 = findViewById(R.id.Num2);

        TextView resultText = findViewById(R.id.Result);

        int num1 = Integer.parseInt(element1.getText().toString());
        int num2 = Integer.parseInt(element2.getText().toString());
        int result = num1+num2;
        resultText.setText(Integer.toString(result));

    }
    public void OnClick2(View view) {
        EditText element1 = findViewById(R.id.Num1);
        EditText element2 = findViewById(R.id.Num2);

        TextView resultText = findViewById(R.id.Result);

        int num1 = Integer.parseInt(element1.getText().toString());
        int num2 = Integer.parseInt(element2.getText().toString());
        int result = num1-num2;
        resultText.setText(Integer.toString(result));
    }
    public void OnClick3(View view) {
        EditText element1 = findViewById(R.id.Num1);
        EditText element2 = findViewById(R.id.Num2);

        TextView resultText = findViewById(R.id.Result);

        int num1 = Integer.parseInt(element1.getText().toString());
        int num2 = Integer.parseInt(element2.getText().toString());
        if(num2 == 0)
        {
            resultText.setText("Деление на ноль...");
        }
        else
        {
            int result = num1/num2;
            resultText.setText(Integer.toString(result));
        }
    }
    public void OnClick4(View view) {
        EditText element1 = findViewById(R.id.Num1);
        EditText element2 = findViewById(R.id.Num2);

        TextView resultText = findViewById(R.id.Result);

        int num1 = Integer.parseInt(element1.getText().toString());
        int num2 = Integer.parseInt(element2.getText().toString());
        int result = num1*num2;
        resultText.setText(Integer.toString(result));
    }

}