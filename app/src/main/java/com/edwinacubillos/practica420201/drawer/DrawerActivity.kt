package com.edwinacubillos.practica420201.drawer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.edwinacubillos.practica420201.R
import com.google.android.material.navigation.NavigationView


class DrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = this.findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val header = navigationView.getHeaderView(0)
        val name: TextView = header.findViewById(R.id.nombre_nav_textview)
        val email: TextView = header.findViewById(R.id.group_nav_textview)
        email.text = getString(R.string.name_app)
        name.text = getString(R.string.team_name)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_area_hexagono,
                R.id.nav_perimetro_hexagono,
                R.id.nav_area_triangulo,
                R.id.nav_perimetro_triangulo,
                R.id.nav_area_rectangulo,
                R.id.nav_perimetro_rectangulo,
                R.id.nav_perimetro_circulo,
                R.id.nav_area_cuadrado,
                R.id.nav_perimetro_cuadrado,
                R.id.nav_area_paralelogramo
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val exit = Intent(Intent.ACTION_MAIN)
            exit.addCategory(Intent.CATEGORY_HOME)
            startActivity(exit)
            finish()
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({
            run {
                doubleBackToExitPressedOnce = false
            }
        }, 2000)
    }
}