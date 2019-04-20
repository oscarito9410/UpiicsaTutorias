package com.booleansystems.tutorias.ui.home.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.tutorias.ui.home.search.model.SearchResponse
import com.google.gson.GsonBuilder

/**

Created by oscar on 20/04/19
operez@na-at.com.mx
 */
class SearchViewModel : ViewModel() {

    val listSearchResults = MutableLiveData<MutableList<SearchResponse>>()

    fun loadDummyData() {
        listSearchResults.value = GsonBuilder().create().fromJson(getDummyJsonData(), Array<SearchResponse>::class.java)
            .toMutableList()
    }

    fun getDummyJsonData(): String {
        return "[\n" +
                "  {\n" +
                "    \"id_materia\": \"1\",\n" +
                "    \"nombre\": \"Logica Programacion\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"2\",\n" +
                "    \"nombre\": \"Tecnologia Digital\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"3\",\n" +
                "    \"nombre\": \"Teoria Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"4\",\n" +
                "    \"nombre\": \"Sociedad, Tecnologia Y Deontologia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"5\",\n" +
                "    \"nombre\": \"Organizacion De Las Computadoras\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"6\",\n" +
                "    \"nombre\": \"Contexto Nacional E Internac I\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"7\",\n" +
                "    \"nombre\": \"Plan De Vida\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"8\",\n" +
                "    \"nombre\": \"Administracion Integral\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"9\",\n" +
                "    \"nombre\": \"Psicologia Del Trabajo\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"10\",\n" +
                "    \"nombre\": \"Herramientas Multimedia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"11\",\n" +
                "    \"nombre\": \"Desarrollo De La Creatividad\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"12\",\n" +
                "    \"nombre\": \"Estructura Y Rep De Datos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"13\",\n" +
                "    \"nombre\": \"Analisis De Sistemas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"14\",\n" +
                "    \"nombre\": \"Contexto Nacional E Internac Ii\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"15\",\n" +
                "    \"nombre\": \"Fundamentos De Lenguaje Ensamblador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"16\",\n" +
                "    \"nombre\": \"Algoritmos Computacionales\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"17\",\n" +
                "    \"nombre\": \"Fundamentos De Programacion Orientada A Objetos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"18\",\n" +
                "    \"nombre\": \"Diseno De Sistemas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"19\",\n" +
                "    \"nombre\": \"Sistemas Operativos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"20\",\n" +
                "    \"nombre\": \"Contexto Nacional E Internac Iii\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"21\",\n" +
                "    \"nombre\": \"Contabilidad Y Costos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"22\",\n" +
                "    \"nombre\": \"Teoria De Lenguajes Y Compiladores\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"23\",\n" +
                "    \"nombre\": \"Programacion Orientada A Objetos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"24\",\n" +
                "    \"nombre\": \"Herramientas Automatizadas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"25\",\n" +
                "    \"nombre\": \"Disea\\u00b1O De Bases De Datos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"26\",\n" +
                "    \"nombre\": \"Comunicacion De Datos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"27\",\n" +
                "    \"nombre\": \"Programacion Lineal\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"28\",\n" +
                "    \"nombre\": \"Legislacion Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"29\",\n" +
                "    \"nombre\": \"Programacion De Dispositivos Moviles\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"30\",\n" +
                "    \"nombre\": \"Programacion Web\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"31\",\n" +
                "    \"nombre\": \"Ingenieria De Software\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"32\",\n" +
                "    \"nombre\": \"Sistemas Manejadores De Bases De Datos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"33\",\n" +
                "    \"nombre\": \"Redes Y Conectividad\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"34\",\n" +
                "    \"nombre\": \"Finanzas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"35\",\n" +
                "    \"nombre\": \"Simulacion De Sistemas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"36\",\n" +
                "    \"nombre\": \"Modelos De Prueba De Software\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"37\",\n" +
                "    \"nombre\": \"Computacion Ubicua\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"38\",\n" +
                "    \"nombre\": \"Administracion Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"39\",\n" +
                "    \"nombre\": \"Planeacion Estrategica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"40\",\n" +
                "    \"nombre\": \"Mejores Practicas De Ti\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"41\",\n" +
                "    \"nombre\": \"Ingenieria Economica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"42\",\n" +
                "    \"nombre\": \"Mercadotecnia E Investigacion De Mercado\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"43\",\n" +
                "    \"nombre\": \"Formulacion De Proyectos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"44\",\n" +
                "    \"nombre\": \"Diseno  De Proyectos De Sistemas Informaticos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"45\",\n" +
                "    \"nombre\": \"Liderazgo Y Desarrollo Directivo\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"46\",\n" +
                "    \"nombre\": \"Inteligencia De Negocios\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"47\",\n" +
                "    \"nombre\": \"Seguridad Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"48\",\n" +
                "    \"nombre\": \"Evaluacion De Proyectos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"49\",\n" +
                "    \"nombre\": \"Desarrollo Emprendedor\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"50\",\n" +
                "    \"nombre\": \"Arquitectura De Las Organizaciones\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"51\",\n" +
                "    \"nombre\": \"Auditoria Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"52\",\n" +
                "    \"nombre\": \"Titulacion Ii\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"53\",\n" +
                "    \"nombre\": \"Modelos De Gestion Informatica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"54\",\n" +
                "    \"nombre\": \"Administracion De Proyectos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"262\",\n" +
                "    \"nombre\": \"Calculo Diferencial E Integral\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"281\",\n" +
                "    \"nombre\": \"Economia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"1041\",\n" +
                "    \"nombre\": \"Algebra Lineal\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"1062\",\n" +
                "    \"nombre\": \"Matematicas Discretas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"1184\",\n" +
                "    \"nombre\": \"Probabilidad\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"1185\",\n" +
                "    \"nombre\": \"Estadistica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_materia\": \"1186\",\n" +
                "    \"nombre\": \"Comunicacion Profesional\"\n" +
                "  }\n" +
                "]";
    }

}