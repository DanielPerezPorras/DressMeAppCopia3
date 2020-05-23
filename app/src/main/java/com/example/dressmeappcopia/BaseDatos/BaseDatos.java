package com.example.dressmeappcopia.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class BaseDatos extends SQLiteOpenHelper {

    private static final int VERSION = 1;

/* TODO: Eliminar, es innecesario
    public BaseDatos (Context contexto) {
        this(contexto, NOMBRE_BASE_DATOS);
    }*/
    public BaseDatos (Context contexto, String nombrebd)
    {
        super(contexto, nombrebd, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        // TABLA PRENDA

        crearTablas(db);
        crearColor(db);
        crearTalla(db);
        crearTipos(db);

        db.execSQL( "INSERT INTO PERFIL VALUES (1  , 'PEPE', 'LOTAD') ") ;

        db.execSQL( "INSERT INTO PRENDA VALUES (1  , 'Prueba1', 'azul',1,3, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (2  , 'Prueba21', 'verda', 4, 2, 1, 1) ") ;

        db.execSQL( "INSERT INTO PRENDA VALUES (3  , 'Prueba14', 'amarillo', 7,1, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (4  , 'Prueba22', 'verda', 4, 2, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (5  , 'Prueba23', 'amarillo', 7,1, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (6  , 'Prueba24', 'verda', 4, 2, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (7  , 'Prueba25', 'amarillo', 7,1, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (8  , 'Prueba26', 'verda', 4, 2, 1, 1) ") ;
        db.execSQL( "INSERT INTO PRENDA VALUES (9  , 'Prueba27', 'amarillo', 7,1, 1, 1) ") ;

        db.execSQL( "INSERT INTO CONJUNTO VALUES (1  , 1,2,3,4,5,6) ") ;
        db.execSQL( "INSERT INTO CONJUNTO VALUES (2  , 6,5,4,3,2,1) ") ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) { }
    }

    private void crearTablas(SQLiteDatabase db){
        String vsql;
        vsql = "CREATE TABLE \"PERFIL\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(50) NOT NULL, \"CONTRASENIA\" VARCHAR(50) NOT NULL)";
        db.execSQL(vsql);

        vsql = "CREATE TABLE \"PRENDA\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(50) NOT NULL, \"COLOR\" VARCHAR(50) NOT NULL" +
                ", \"TIPO\" INTEGER NOT NULL, \"TALLA\" INTEGER NOT NULL,\"VISIBLE\" INTEGER NOT NULL, \"ID_PERFIL\" INTEGER NOT NULL )";

        db.execSQL(vsql);

        vsql = "CREATE TABLE \"ENTRADA_HISTORIAL\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(50) NOT NULL, \"FORMALIDAD\" INTEGER NOT NULL" +
                ", \"TIEMPO\" INTEGER NOT NULL, \"TEMPERATURA\" INTEGER NOT NULL,\"FECHA\" INTEGER NOT NULL, \"ID_PRENDA\" INTEGER NOT NULL  )";

        db.execSQL(vsql);

        vsql = "CREATE TABLE \"CONJUNTO\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"ABRIGO\" INTEGER ,\"SUDADERA\" INTEGER , \"CAMISETA\" INTEGER NOT NULL, " +
                "\"PANTALON\" INTEGER NOT NULL, \"ZAPATO\" INTEGER NOT NULL, \"COMPLEMENTO\" INTEGER )";
        db.execSQL(vsql);

        db.execSQL("CREATE TABLE \"COLOR\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(20) NOT NULL)");
        db.execSQL("CREATE TABLE \"TIPO\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(20) NOT NULL)");
        db.execSQL("CREATE TABLE \"TALLA\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"NOMBRE\" VARCHAR(20) NOT NULL)");
    }

    private void crearTipos(SQLiteDatabase db){
        // ACTUALIZAR LOS VALORES


        db.execSQL( "INSERT INTO TIPO VALUES (1  , 'ABRIGO') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (2  ,'BAÑADOR/BIKINI' ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (3 , 'BLUSA') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (4  , 'CAMISA') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (5  ,  'CAMISETA'  ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (6  ,'CHANCLAS'  ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (7 , 'CHAQUETA') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (8  ,'COMPLEMENTO'  ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (9  , 'FALDA') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (10  ,'JERSEY' ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (11  ,'PANTALON' ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (12 ,'POLO' ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (13 , 'SUDADERA') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (14  , 'TENNIS') ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (15  , 'TRAJE' ) ") ;
        db.execSQL( "INSERT INTO TIPO VALUES (16  ,'ZAPATOS' ) ") ;

    }

    private void crearTalla(SQLiteDatabase db){

        db.execSQL( "INSERT INTO TALLA VALUES (1  , 'M') ") ;
        db.execSQL( "INSERT INTO TALLA VALUES (2  , 'L') ") ;
        db.execSQL( "INSERT INTO TALLA VALUES (3  , 'S') ") ;
        db.execSQL( "INSERT INTO TALLA VALUES (4  , 'XL') ") ;
        db.execSQL( "INSERT INTO TALLA VALUES (5  , 'XS') ") ;
        db.execSQL( "INSERT INTO TALLA VALUES (6  , 'XXL') ") ;

    }

    private void crearColor(SQLiteDatabase db){


        db.execSQL( "INSERT INTO COLOR VALUES (1  , 'AZUL') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (2  , 'AMARILLO') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (3  , 'BLANCO') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (4  , 'GRIS') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (5  , 'MARRON') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (6  , 'MORADO') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (7  , 'NARANJA') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (8  , 'NEGRO') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (9  , 'ROJO') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (10  , 'ROSA') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (11  , 'VERDE') ") ;
        db.execSQL( "INSERT INTO COLOR VALUES (12 , 'VIOLETA') ") ;

    }

}
