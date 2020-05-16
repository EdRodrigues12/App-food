package com.br.villasfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.br.villasfood.model.MenuOption
import com.br.villasfood.ui.activity.ListFoodActivity
import com.br.villasfood.ui.activity.ListSodasActivity
import com.br.villasfood.ui.activity.ListWineActivity
import com.br.villasfood.ui.adapter.recyclerview.ListMenuOptionOrderAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListMenuOptionOrderAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_option_food, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.lanches -> {
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
                true
            }
//            R.id.bebidas -> {
//                true
//            }
            R.id.refrigerante -> {
                val intent = Intent(this, ListSodasActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.vinho -> {
                val intent = Intent(this, ListWineActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun configRecyclerView() {
        lista_pacotes_listview.layoutManager = GridLayoutManager(this, 2)
        lista_pacotes_listview.adapter = adapter
        configAdapter()
    }

    private fun configAdapter() {
        adapter.quandoItemClicado = this::goToOption
    }

    private fun goToOption(it: MenuOption) {
         when (it.name) {
            "Lanches" -> {
                val intent = Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
            }
            "Refrigerantes" -> {
                val intent = Intent(this, ListSodasActivity::class.java)
                startActivity(intent)
            }
            "Vinhos" -> {
                val intent = Intent(this, ListWineActivity::class.java)
                startActivity(intent)
                true
            }
        }
    }
}
