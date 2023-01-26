package com.example.aa_bssd_5250_21

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instantiate an ImageView and define its properties
        val r = makeButton("red")

        val b = makeButton("blue")

        // Create a ConstraintLayout in which to add the ImageView
        val redLinearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            // Add the ImageView to the layout.
            addView(r) // add the red image
        }
        val blueLinearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            // Add the ImageView to the layout.
            addView(b) // add the red image
        }
        val linearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.BLUE)
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            // Add the ImageView to the layout.
            addView(redLinearLayout)
            addView(blueLinearLayout)
        }
//
        // Set the layout as the content view.
        setContentView(linearLayout)
//        setContentView(R.layout.activity_main)
    }
    fun makeButton(color: String?):ImageButton{
        lateinit var button:ImageButton
        if(color == "red"){
            button = ImageButton(this).apply {
                setImageResource(R.drawable.red)
                contentDescription =  "Red Dot image"
                setOnClickListener(View.OnClickListener { view ->
                    (view.parent as LinearLayoutCompat)?.addView(makeButton("blue"))
                })
                // set the ImageView bounds to match the Drawable's dimensions
                adjustViewBounds = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }else{//must be blue
            button = ImageButton(this).apply {
                setImageResource(R.drawable.blue)
                background = null
                contentDescription =  "Blue Dot image"
                setOnClickListener{
                    (it.parent as LinearLayoutCompat)?.removeView(it)
                }
                // set the ImageView bounds to match the Drawable's dimensions
                adjustViewBounds = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        return button
    }//end of fun makeButton(color: String):ImageButton
}