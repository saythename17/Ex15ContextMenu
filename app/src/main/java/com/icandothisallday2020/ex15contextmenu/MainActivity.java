package com.icandothisallday2020.ex15contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);

        //Activity 에 Button 객체를 ContextMenu 로 등록
        this.registerForContextMenu(btn);
    }
    //Context Menu 로 지정된 View(btn) 을 long click 시
    //보여지는  Context Menu 를 만드는 callback method
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //전달받은 menu 객체에 MenuItem 추가
        //res/menu/context.xml 파일을 만들어 메뉴항목에 추가
        //xml 문서를 Menu 객체로 만들기 (부풀리다)
        MenuInflater menuInflater=getMenuInflater();//this. 생략
        menuInflater.inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //Context menu item click 시 자동 발동되는 callback method
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu_save:
                Toast.makeText(this,"save",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete:
                Toast.makeText(this, "delete",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void click(View view) {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
    }
}
