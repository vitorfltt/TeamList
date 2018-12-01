package aula.fib.br.customizedlist

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream


class DetalheTime : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_contato)

        val intent = intent
        if (intent != null) {
            val campeao = intent.getSerializableExtra("campeao") as Time
            val nomecampeao = findViewById<TextView>(R.id.nometime)
            val desccampeao = findViewById<TextView>(R.id.titulotime)
            val imageView = findViewById<ImageView>(R.id.fototime)
            imageView.setImageBitmap(getBitmapFromAsset(campeao.id));

            /*if (contato.id.equals(6)){
                val mPlayer = MediaPlayer.create(this@DetalheTime, R.raw.c6)
                mPlayer.start()
            }*/

            //TODO: Play sounds
            /*var id = contato.id
            var afd: AssetFileDescriptor? = null
            try {
                val afd = assets.openFd("sounds/c$id.mp3")
                val player = MediaPlayer()
                player.setDataSource(afd.fileDescriptor)
                player.prepare()
                player.start()
            } catch (e: IOException) {
                val afd = assets.openFd("sounds/urna.mp3")
                val player = MediaPlayer()
                player.setDataSource(afd.fileDescriptor)
                player.prepare()
                player.start()
            }*/

            nomecampeao.text = campeao.nome
            desccampeao.text = campeao.titulo
        }
    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = assets
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.jpg")
        }
        return BitmapFactory.decodeStream(istr)
    }
}
