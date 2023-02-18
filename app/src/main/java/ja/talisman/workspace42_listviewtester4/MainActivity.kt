package ja.talisman.workspace42_listviewtester4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val dataList = arrayListOf<textContainer>()
    var listView1 = findViewById<ListView>(R.id.listview1)
    override fun onCreate(savedInstanceState: Bundle?) {
        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = CustomAdapter(this,dataList)
        listView1.adapter=adapter
        button1.setOnClickListener{
            dataList.add(dataList.size-1, textContainer("inserted"))
            adapter.notifyDataSetChanged()
        }
        button3.setOnClickListener {
            dataList.removeLast()
            adapter.notifyDataSetChanged()
        }
    }
}
data class textContainer(
    var text: String? = null
)
class CustomAdapter(context: Context, list: ArrayList<textContainer>):ArrayAdapter<textContainer>(context,0,list){
    override fun getView(position: Int,convertView: View?,parent: ViewGroup): View {
        var view = convertView
        if(view == null){view= LayoutInflater.from(context).inflate(R.layout.row_view,parent,false)}
        val data = getItem(position)
        view?.findViewById<TextView>(R.id.containerText).apply { data?.text }
        return view!!
    }
}