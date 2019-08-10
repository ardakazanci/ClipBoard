package com.ardakazanci.clipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	EditText edtCopy, edtPaste;
	Button btnCopy, btnPaste;


	ClipboardManager clipboardManager;
	ClipData clipData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edtCopy = findViewById(R.id.edtCopy);
		edtPaste = findViewById(R.id.edtPaste);

		btnCopy = findViewById(R.id.btnCopy);
		btnPaste = findViewById(R.id.btnPaste);


		clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		btnCopy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String text = edtCopy.getText().toString();
				clipData = ClipData.newPlainText("text", text);
				clipboardManager.setPrimaryClip(clipData);

				Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();

			}
		});


		btnPaste.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				ClipData data = clipboardManager.getPrimaryClip();
				ClipData.Item item = data.getItemAt(0);

				String text = item.getText().toString();
				edtPaste.setText(text);

				Toast.makeText(MainActivity.this, "Text Pasted", Toast.LENGTH_SHORT).show();


			}
		});

	}
}
