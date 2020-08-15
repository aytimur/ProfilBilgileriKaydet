package ibrahim.aytimur.profilbilgilerikaydet

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sharedPreferences = this.getSharedPreferences("ProfilBilgileri", Context.MODE_PRIVATE)

        btnKaydet.setOnClickListener {
            var adiSoyadi = adSoyadText.text.toString()
            var yasi = yasText.text.toString()
            if (adiSoyadi.isNotEmpty()&&yasi.isNotEmpty()){
                sharedPreferences.edit().putString("adSoyad",adiSoyadi).apply()
                sharedPreferences.edit().putString("yas",yasi).apply()
                adSoyadText.text.clear()
                yasText.text.clear()
                Toast.makeText(applicationContext,"Kayıt başarılı",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"İlgili alanları boş bırakmayınız",Toast.LENGTH_LONG).show()
            }

        }
        btnGoster.setOnClickListener {
            var gosterAdSoyad = sharedPreferences.getString("adSoyad","")
            var gosterYas = sharedPreferences.getString("yas","")
            textView.text = gosterAdSoyad+"\n"+gosterYas
        }

        btnSil.setOnClickListener {
            //sharedPreferences.edit().clear().apply()
           sharedPreferences.edit().remove("yas").apply()
        }
    }
}