package intro.cm.cm.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;

public class BD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "notas.bd";

    public BD(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(NotasBD.Categoria.SQL_CREATE_ENTRIES);
        db.execSQL(NotasBD.Nota.SQL_CREATE_ENTRIES);


        db.execSQL("insert into " + NotasBD.Categoria.TABLE_NAME + " values (1, 'Lembrete');");
        db.execSQL("insert into " + NotasBD.Categoria.TABLE_NAME + " values (2, 'Reuniao');");
        db.execSQL("insert into " + NotasBD.Categoria.TABLE_NAME + " values (3, 'Palavras-Passe');");


        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (1 , 'nota1', 'desc1' , 'data1', 1);");
        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (2 , 'nota2', 'desc2' , 'data2', 1);");
        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (3 , 'nota3', 'desc3' , 'data3', 2);");
        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (4 , 'nota4', 'desc4' , 'data4', 3);");
        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (5 , 'nota5', 'desc5' , 'data5', 1);");
        db.execSQL("insert into " + NotasBD.Nota.TABLE_NAME + " values (6 , 'nota6', 'desc6' , 'data6', 2);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NotasBD.Nota.SQL_DROP_ENTRIES);
        db.execSQL(NotasBD.Categoria.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
