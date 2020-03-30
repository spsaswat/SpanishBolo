package com.fake_era.spanishbolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import java.util.Locale;

public class toSpanish extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText editText;
    TextView textView;
    private TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_spanish);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    Locale locale = new Locale("es", "ES");
                    int result = mTTS.setLanguage(locale);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {

                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
    }

    public void translate(View view) {

        TranslateAPI translateAPI = new TranslateAPI(
                Language.AUTO_DETECT,
                Language.SPANISH,
                editText.getText().toString());

        translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
            @Override
            public void onSuccess(String translatedText) {
                Log.d(TAG, "onSuccess: "+translatedText);
                textView.setText(translatedText);
            }

            @Override
            public void onFailure(String ErrorText) {
                Log.d(TAG, "onFailure: "+ErrorText);
            }
        });

    }

    public void speak(View view) {
        mTTS.setSpeechRate(.8f);
        mTTS.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
