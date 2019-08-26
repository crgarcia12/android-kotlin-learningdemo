package ar.com.crgarcia.helloworldkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val initialTextViewtranslationY = textview_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textview_progress.text = p1.toString()

                val translationDistance = (initialTextViewtranslationY + p1 * resources.getDimension(R.dimen.text_anim_step) * -1)

                textview_progress.animate().translationY(translationDistance)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        button_reset.setOnClickListener { view ->
            seekBar.progress = 0
            textview_progress.animate().setDuration(500).rotationBy(360f)
                .translationY(initialTextViewtranslationY)
        }
    }
}
