package br.com.helderrangel.atividade

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.ivFoto)
    }

    private val foto =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val bitmap = it?.data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
        }

    fun fotografar(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            foto.launch(intent)
        }
        Log.i("CameraFoto","informação")
        Log.w("CameraFoto","aviso")
        Log.e("CameraFoto","erro")
    }


}




