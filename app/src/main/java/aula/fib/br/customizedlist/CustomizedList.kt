package aula.fib.br.customizedlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CustomizedList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customized_list)

        val listaTimes = ArrayList<Time>()
        listaTimes.add(Time(1L, "Palmeiras", "1 Copa Libertadores, 1 Copa Mercosul, 4 Brasileiros, 2 Torneios Roberto Gomes Pedrosa, 2 Taças Brasil, 3 Copas do Brasil, 1 Copa dos Campeões, 2 Séries B, 5 Rio-São Paulo e 22 Paulistas."))
        listaTimes.add(Time(2L, "São Paulo", "3 Mundiais, 3 Copas Libertadores, 2 Recopas Sul-Americana, 1 Copa Sul-Americana, 1 Super Copa Libertadores, 1 Copa Conmebol, 6 Brasileiros, 1 Rio-São Paulo, 1 SuperCampeonato Paulista e 20 Paulistas."))
        listaTimes.add(Time(3L, "Atletico PR", "1 Brasileiro, 1 Série B, 1 SuperCampeonato Paranaense e 22 Paranaenses."))
        listaTimes.add(Time(4L, "Vasco", "1 Copa Libertadores, 1 Campeonato Sul-Americano de Campeões, 1 Copa Mercosul, 4 Brasileiros, 1 Copa do Brasil, 1 Série B, 3 Rio-São Paulo e 24 Cariocas."))
        listaTimes.add(Time(6L, "Atletico MG", "1 Copa Libertadores, 2 Copas Conmebol, 1 Recopa Sul-Americana, 1 Brasileiro, 1 Copa do Brasil, 2 Copas dos Campeões, 1 Série B e 43 Mineiros."))
        listaTimes.add(Time(5L, "Flamengo", "1 Mundial, 1 Copa Libertadores, 1 Copa Mercosul, 5 Brasileiros, 3 Copas do Brasil, 1 Copa dos Campeões, 1 Rio-São Paulo e 33 Cariocas."))
        listaTimes.add(Time(7L, "Cruzeiro", "2 Copas Libertadores, 2 Super Copas Libertadores, 1 Recopa Sul-Americana, 3 Brasileiros, 1 Taça Brasil, 4 Copas do Brasil, 1 Copa Centro-Oeste, 2 Copas Sul-Minas, 1 SuperCampeonato Mineiro e 37 Mineiros."))
        listaTimes.add(Time(8L, "Chapecoense", "5 Catarinenses,1 sul-americana"))
        listaTimes.add(Time(9L, "Fluminense", "3 Brasileiros, 1 Torneio Roberto Gomes Pedrosa, 1 Copa do Brasil, 1 Série C, 2 Rio-São Paulo e 31 Cariocas. "))
        listaTimes.add(Time(10L, "Bahia", "1 Brasileiro, 1 Taça Brasil, 1 Série B, 2 Copas Nordeste e 45 Baianos."))
        listaTimes.add(Time(11L, "Gremio", "1 Mundial, 2 Copas Libertadores, 1 Recopa Sul-Americana, 2 Brasileiros, 4 Copas do Brasil, 1 Super Copa do Brasil, 1 Série B, 1 Copa Sul e 36 Gaúchos. "))
        listaTimes.add(Time(12L, "Internacional", "1 Mundial, 2 Copas Libertadores, 2 Recopas Sul-Americana, 1 Copa Sul-Americana, 3 Brasileiros, 1 Copa do Brasil e 45 Gaúchos."))

        val adapter = TimeAdapter(applicationContext, listaTimes, assets)

        val lista = findViewById<ListView>(R.id.lista)
        lista.setAdapter(adapter)

        lista.setOnItemClickListener {parent, view, position, id ->
            val campeao = listaTimes.get(position)
            val intent = Intent(this, DetalheTime::class.java)
            intent.putExtra("campeao", campeao)
            startActivity(intent)
        }
    }
}
