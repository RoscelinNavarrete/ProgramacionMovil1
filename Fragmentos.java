<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <!-- Parte superior: ListView con los animales -->
    <ListView
        android:id="@+id/listaAnimales"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="#EEEEEE"/>

    <!-- Divisor -->
    <View
        android:layout_width="match_parent"
        android:layout_height="2dp"
        android:background="#999999"/>

    <!-- Parte inferior: contenedor del fragmento -->
    <FrameLayout
        android:id="@+id/contenedorFragmento"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="2"
        android:background="#FFFFFF"/>

</LinearLayout>

  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <ImageView
        android:id="@+id/imgAnimal"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:scaleType="centerCrop"
        android:contentDescription="Animal"/>

    <TextView
        android:id="@+id/txtNombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="24sp"
        android:textStyle="bold"
        android:layout_marginTop="12dp"/>

    <TextView
        android:id="@+id/txtDescripcion"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="8dp"
        android:gravity="center"/>

</LinearLayout>

  package com.example.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentoAnimal extends Fragment {

    // Claves para los argumentos
    private static final String ARG_NOMBRE      = "nombre";
    private static final String ARG_DESCRIPCION = "descripcion";
    private static final String ARG_IMAGEN      = "imagen";

    // Método estático para crear el fragmento con datos
    public static FragmentoAnimal newInstance(String nombre, String descripcion, int imagenRes) {
        FragmentoAnimal f = new FragmentoAnimal();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_DESCRIPCION, descripcion);
        args.putInt(ARG_IMAGEN, imagenRes);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragmento_animal, container, false);

        ImageView imgAnimal    = vista.findViewById(R.id.imgAnimal);
        TextView  txtNombre    = vista.findViewById(R.id.txtNombre);
        TextView  txtDescripcion = vista.findViewById(R.id.txtDescripcion);

        if (getArguments() != null) {
            txtNombre.setText(getArguments().getString(ARG_NOMBRE));
            txtDescripcion.setText(getArguments().getString(ARG_DESCRIPCION));
            imgAnimal.setImageResource(getArguments().getInt(ARG_IMAGEN));
        }

        return vista;
    }
}

  package com.example.fragmentos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    // Nombres de los animales (lo que aparece en el ListView)
    String[] animales = {"🐱 Gato", "🐶 Perro", "🐰 Conejo"};

    // Descripciones de cada animal
    String[] descripciones = {
        "El gato es un mamífero carnívoro doméstico. Es ágil, independiente y uno de los animales de compañía más populares del mundo.",
        "El perro es conocido como el mejor amigo del hombre. Es leal, sociable y existe en cientos de razas distintas.",
        "El conejo es un mamífero herbívoro muy tierno. Es curioso, activo y le encanta explorar su entorno."
    };

    // IDs de las imágenes (deben existir en res/drawable)
    int[] imagenes = {
        R.drawable.gato,
        R.drawable.perro,
        R.drawable.conejo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.listaAnimales);

        // Adaptador simple con el array de nombres
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            animales
        );
        lista.setAdapter(adaptador);

        // Al tocar un elemento, carga el fragmento correspondiente
        lista.setOnItemClickListener((parent, view, position, id) -> {
            FragmentoAnimal fragmento = FragmentoAnimal.newInstance(
                animales[position],
                descripciones[position],
                imagenes[position]
            );

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedorFragmento, fragmento);
            transaction.addToBackStack(null); // permite volver atrás
            transaction.commit();
        });
    }
}

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:label="Fragmentos Animales"
        android:theme="@style/Theme.AppCompat.Light.NoActionBar">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>

    </application>

</manifest>
