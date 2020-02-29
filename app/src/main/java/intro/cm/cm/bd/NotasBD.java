package intro.cm.cm.bd;

import android.provider.BaseColumns;

public class NotasBD {

    private static final String TEXT_TYPE = " TEXT ";
    private static final String INT_TYPE = " INTEGER ";

    public NotasBD(){

    }

    public static abstract class Nota implements BaseColumns{
        public static final String TABLE_NAME =  "notas";
        public static final String COLUMN_title =  "title";
        public static final String COLUMN_desc =  "desc";
        public static final String COLUMN_date =  "date";
        public static final String COLUMN_id_categoria = "id_categoria";

        public static final String[] PROJECTION = {Nota._ID, Nota.COLUMN_title, Nota.COLUMN_desc, Nota.COLUMN_date, Nota.COLUMN_id_categoria};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Nota.TABLE_NAME + "(" +
                        Nota._ID + INT_TYPE + " PRIMARY KEY," +
                        Nota.COLUMN_title + TEXT_TYPE + "," +
                        Nota.COLUMN_desc + TEXT_TYPE + "," +
                        Nota.COLUMN_date + TEXT_TYPE + "," +
                        Nota.COLUMN_id_categoria + INT_TYPE + "," +
                        " FOREIGN KEY (" + Nota.COLUMN_id_categoria + ") REFERENCES " +
                        Categoria.TABLE_NAME + "(" + Categoria._ID + "));";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE IF EXISTS " + Nota.TABLE_NAME + ";";

    }

    public static abstract class Categoria implements BaseColumns {
        public static final String TABLE_NAME = "categoria";
        public static final String COLUMN_descr = "descr";

        public static final String[] PROJECTION = {Categoria._ID, Categoria.COLUMN_descr};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Categoria.TABLE_NAME + "(" +
                        Categoria._ID + INT_TYPE + " PRIMARY KEY," +
                        Categoria.COLUMN_descr + TEXT_TYPE + ");";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Categoria.TABLE_NAME;

    }

}
