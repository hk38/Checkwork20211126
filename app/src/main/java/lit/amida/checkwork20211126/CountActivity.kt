package lit.amida.checkwork20211126

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.TextView

class CountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        val count = 0
        val textSizeList = listOf(32f, 40f, 52f)
        val textView = findViewById<TextView>(R.id.result_text)

        findViewById<Button>(R.id.count_button).setOnClickListener {
            if(count <= Int.MAX_VALUE) return@setOnClickListener

            count++
            textView.text = count.toString()
            textView.textSize = textSizeList[count]
            textView.setTextColor(Color.HSVToColor(floatArrayOf(count*20f, 0.8f, 0.8f)))

        }

        findViewById<Button>(R.id.count_to_result_button).setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            intent.putExtra("value", count)
        }
    }
}