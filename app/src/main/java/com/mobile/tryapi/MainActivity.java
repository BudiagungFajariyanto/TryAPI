package com.mobile.tryapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText Edtnama, Edtemail, Edtnomor, Edtpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edtnama = findViewById(R.id.editnama);
        Edtemail = findViewById(R.id.editemail);
        Edtnomor = findViewById(R.id.editnomor);
        Edtpesan = findViewById(R.id.editpesan);

        button = findViewById(R.id.btnkirim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesan1 = Edtnama.getText().toString();
                String pesan2 = Edtemail.getText().toString();
                String pesan3 = Edtnomor.getText().toString();
                String pesan4 = Edtpesan.getText().toString();

                String semuapesan = "Nama : " + pesan1 + "\n" +
                                    "Email : " + pesan2 + "\n" +
                                    "No. HP : " + pesan3 + "\n" +
                                    "Pesan : " + pesan4 + "\n";

                Intent kirimWa = new Intent(Intent.ACTION_SEND);
                kirimWa.setType("text/plain");
                kirimWa.putExtra(Intent.EXTRA_TEXT, semuapesan);
                kirimWa.putExtra("jid", "6282114456007" + "@s.whatsapp.net");
                kirimWa.setPackage("com.whatsapp");

                startActivity(kirimWa);
            }
        });

    }
}