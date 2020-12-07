package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.OneShotPreDrawListener.add
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    init {
        System.loadLibrary("native-lib")
    }

    external fun add(a: Int, b: Int): Int

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            val numberOne: Int = numberOne.text.toString().toInt()
            val numberTwo: Int = numberTwo.text.toString().toInt()
            val sum: Int  = add(numberOne, numberTwo)
            textview_first.setText("Result: $sum")
        }
    }
}