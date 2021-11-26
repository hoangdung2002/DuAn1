package com.bai.duan1_cp16306_nhom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    Toolbar toolbar;
    View mHeaderView;
    TextView edUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar1);
        //set toolber thay thế chp actionbar
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();

//        ab.setHomeAsUpIndicator(R.drawable.m);
        ab.setDisplayHomeAsUpEnabled(true);

        NavigationView nv = findViewById(R.id.nvView);
        //show user in header
        mHeaderView = nv.getHeaderView(0);
        edUser = mHeaderView.findViewById(R.id.txtUser);
        Intent i = getIntent();
        edUser.setText("welcome!");

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                switch (item.getItemId()){
                    case R.id.nav_DanhSach:
                        setTitle("Danh Sách Sản Phẩm");
                        break;
                    case R.id.nav_LichSu:
                        setTitle("Lịch Sử");
                        break;
                    case R.id.nav_GioHang:
                        setTitle("Giỏ Hàng");
                        break;
                    case R.id.sub_Top:
                        setTitle("Món ăn đặt hàng nhiều nhất");
                        break;
                    case R.id.sub_DoanhThu:
                        setTitle("Doanh Thu");
                        break;
                    case R.id.sub_profile:
                        setTitle("profile");
                        break;
                    case R.id.sub_AddUser:
                        setTitle("Thêm người dùng");
                        break;
                    case R.id.sub_Logout:
                        setTitle("Đăng xuất");
                        break;
                }

                drawer.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home)
            drawer.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }
}