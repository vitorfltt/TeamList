package aula.fib.br.customizedlist

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream

class TimeAdapter(context: Context, lista: ArrayList<Time>, assetManager: AssetManager) : BaseAdapter() {

    private var listaCampeoes: ArrayList<Time>
    private var inflator: LayoutInflater
    private var assetManager: AssetManager

    init {
        this.listaCampeoes = lista
        this.inflator = LayoutInflater.from(context)
        this.assetManager = assetManager
    }

    override fun getCount(): Int {
        return this.listaCampeoes.size
    }

    override fun getItem(position: Int): Any? {
        return this.listaCampeoes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.listaCampeoes.get(position).id;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val contato = this.listaCampeoes.get(position)
        val bitmapImage = this.getBitmapFromAsset(contato.id)

        var holder: ViewHolder
        var retView: View

        if(convertView == null){
            retView = this.inflator.inflate(R.layout.linha, parent, false)
            holder = ViewHolder()
            holder.nome = retView.findViewById<TextView>(R.id.nome)
            holder.foto = retView.findViewById<ImageView>(R.id.foto)
            retView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            retView = convertView
        }

        holder.nome?.setText(contato.nome)
        holder.foto?.setImageBitmap(bitmapImage)

        return retView
    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = this.assetManager
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.jpg")
        }
        return BitmapFactory.decodeStream(istr)
    }

    internal class ViewHolder {
        var nome: TextView? = null
        var foto: ImageView? = null
    }
}