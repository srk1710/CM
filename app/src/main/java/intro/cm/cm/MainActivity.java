package intro.cm.cm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import intro.cm.cm.bd.BD;
import intro.cm.cm.bd.NotasBD;

public class MainActivity extends AppCompatActivity {

    BD mdbhelper;
    SQLiteDatabase db;
    Cursor c;
    ListView lista;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddNotesActivity.class);
                startActivity(intent);

            }
        });

        mdbhelper = new BD(this);
        db = mdbhelper.getReadableDatabase();

        lista = (ListView) findViewById(R.id.lista);
        // registerForContextMenu(lista);
        preencheLista();
        
         }


         private void preencheLista(){
            c = db.query(false, NotasBD.Nota.TABLE_NAME, NotasBD.Nota.PROJECTION, null, null,
                    null, null, null, null);

            adapter = new SimpleCursorAdapter(this,
                    android.R.layout.two_line_list_item,
                    c,
                    new String[] {NotasBD.Nota.COLUMN_title, NotasBD.Nota.COLUMN_desc},
                    new int[] {android.R.id.text1, android.R.id.text2},
                    SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

            lista.setAdapter(adapter);
         }

}
