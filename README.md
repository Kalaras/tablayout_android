# tablayout_android

Este ejemplo de TabLayout utiliza la libreria de material design de google.

## Paso 1:
  En el archivo **build.gradle** agregar la siguiente dependencia
  ```gradle 
  implementation 'com.google.android.material:material:1.0.0'
  ```

## Paso 2:
  En el archivo activity_main.xml, agregar el TabLayout y el ViewPager.
  ```xml 
  <com.google.android.material.tabs.TabLayout
        android:id="@+id/tab"
        android:elevation="4dp"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:background="?attr/colorPrimaryDark"
        android:minHeight="?attr/actionBarSize"
        app:tabSelectedTextColor="#fff"
        android:theme="@style/ThemeOverlay.MaterialComponents.ActionBar" />
        
  <androidx.viewpager.widget.ViewPager
        android:layout_below="@id/tab"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/pager" />
  ```
## Paso 3:
  Para este ejemplo debemos crear 3 fragments en blanco, donde pueden agregar un TextView en el xml correspondiente al fragment para diferenciarlos entre si.
## Paso 4:
  Crear una clase que servirá como adapter para el ViewPager. Esta clase debe extender de **FragmentStatePagerAdapter** para implementar los métodos para obtener los tab y el numero de tab.
  ```java
  public class CustomTabAdapter extends FragmentStatePagerAdapter {

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
  ```
  Una vez implementados los métodos base para el adapter, debemos crear el constructor de esta clase. Este constructor debe recibir el numero de tabs a mostrar y el **FragmentManager** que se agrega por defecto.
  ```java
  public class CustomTabAdapter extends FragmentStatePagerAdapter {
  
    private int numerosTab;

    public CustomTabAdapter(FragmentManager fm, int numerosTab) {
        super(fm);
        this.numerosTab = numerosTab;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
  ```
  Ahora en el método **getCount()** retornaremos la cantidad de tabs que deseamos mostrar y en el método **getItem()** retornaremos los fragment correspondientes a cada tab.
  ```java
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0: return new Tab1Fragment();
      case 1: return new Tab2Fragment();
      case 2: return new Tab3Fragment();
      default: return null;
    }
  }

  @Override
  public int getCount() {
    return numerosTab;
  }
  ```
## Paso 5:
En el archivo **MainActivity.java** obtendremos los elementos del xml para poder trabajar con ellos.
  ```java
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      TabLayout tab = (TabLayout) findViewById(R.id.tab);
      ViewPager pager = (ViewPager) findViewById(R.id.pager);
  }
  ```
  Ahora que ya tenemos los elementos del xml podemos agregar los tab. Estos tab deben corresponder al orden establecido en el adapter personalizado creado en el paso anterior.
  
  ```java
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      TabLayout tab = (TabLayout) findViewById(R.id.tab);
      ViewPager pager = (ViewPager) findViewById(R.id.pager);

      tab.addTab(tab.newTab().setText("TAB 1"));
      tab.addTab(tab.newTab().setText("TAB 2"));
      tab.addTab(tab.newTab().setText("TAB 3"));

      tab.setTabGravity(TabLayout.GRAVITY_FILL); //esta configuración es para que los tab se ajusten al TabLayout
  }
  ```
  Instanciar el adapter personalizado para pasarlo al ViewPager
  ```java
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      ...

      //Instancio el custom adapter
      CustomTabAdapter adapter = new CustomTabAdapter(getSupportFragmentManager(), tab.getTabCount());

      //le paso el adapter al viewpager
      pager.setAdapter(adapter);
      pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
  }
  ```
  
  
