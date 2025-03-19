package com.example.chapterfive;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MenuDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_demo);
        Button contextMenubtn=findViewById(R.id.contextMenuBtn);
        registerForContextMenu(contextMenubtn);
        Button popUpBtn= findViewById(R.id.popupMenuBtn);
        popUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(MenuDemoActivity.this,view);
                popupMenu.inflate(R.menu.menu_items);
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_items,menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_items, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuItem1) {
            Snackbar.make(findViewById(android.R.id.content),"item 1 selected", Snackbar.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId()==R.id.menuItem2){
            Snackbar.make(findViewById(android.R.id.content),"item 2 selected", Snackbar.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}