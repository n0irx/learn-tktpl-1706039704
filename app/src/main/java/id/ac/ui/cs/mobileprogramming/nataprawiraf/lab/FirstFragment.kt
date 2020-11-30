package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    private lateinit var wifiManager: WifiManager
    private lateinit var results: List<ScanResult>
    private lateinit var adapter: ArrayAdapter<*>
    private var wifiArrayList: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scanBtn.setOnClickListener {
            scanWifi()
        }

        wifiManager = activity?.applicationContext?.getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager

        if (!wifiManager.isWifiEnabled) {
            Toast.makeText(activity, "WiFi is disabled, you should enable it", Toast.LENGTH_LONG).show();
        }

        adapter = ArrayAdapter(
            activity?.applicationContext!!,
            R.layout.support_simple_spinner_dropdown_item,
            wifiArrayList
        )
        wifiList.adapter = adapter
        scanWifi()
    }

    private fun scanWifi(){
        wifiArrayList.clear()
        activity?.registerReceiver(
            wifiReceiver,
            IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        )
        wifiManager.startScan()
        Toast.makeText(activity, "Scanning WiFi ...", Toast.LENGTH_SHORT).show()
    }

    private val wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            results = wifiManager.scanResults
            activity?.unregisterReceiver(this)

            val resultMap: MutableMap<String, String> = HashMap()

            for (scanResult in results) {
                wifiArrayList.add(scanResult.SSID + " - " + scanResult.capabilities)
                adapter.notifyDataSetChanged()
                resultMap[scanResult.SSID] = scanResult.capabilities
            }

            val postBody = Gson().toJson(resultMap)
            Fuel.post("https://66a3fa4cb854b0883bec17ebad880837.m.pipedream.net")
                .jsonBody(postBody)
                .also { println(it) }
                .response { result ->
                    Toast.makeText(activity, "HTTP request sent", Toast.LENGTH_SHORT).show()
                }

            Toast.makeText(activity, "Finished Scanning", Toast.LENGTH_SHORT).show()
        }
    }
}