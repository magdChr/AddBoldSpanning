package com.example.addboldspanning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        var s = null

    }

    fun String.addBoldSpanning(): CharSequence{
        var strToSpan:CharSequence  = this
        var finalStr = SpannableStringBuilder("")
        var indexstart = 0
        var indexend = 0

        while (indexstart != -1) {
            indexstart = strToSpan.indexOf("<strong>",ignoreCase = true)
            indexend = strToSpan.indexOf("</strong>", ignoreCase = true)

            if((indexstart != -1)&&(indexend !=-1)){
                val strToSpanBold = SpannableStringBuilder( strToSpan.substring(indexstart + "<strong>".length, indexend))
                strToSpanBold.setSpan(
                        StyleSpan(Typeface.BOLD), 0, strToSpanBold.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                finalStr = finalStr.append(SpannableStringBuilder(strToSpan.substring(0, indexstart))).append(strToSpanBold)
                strToSpan = strToSpan.substring(indexend +"</strong>".length, strToSpan.length)
            }else break
        }
        return finalStr.append(strToSpan)
    }
}