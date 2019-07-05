package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding EditText

        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.edt_txt_email);

        // Binding edt_txt_password ke variabel editTextPassword
        editTextPassword = findViewById(R.id.edt_new_password);

        // Binding edt_txt_password ke variabel editTextPassword
        editTextConfirmPassword = findViewById(R.id.edt_confirm_password);

    }

    public void postChangePassword(View view) {
        // Ambil text email dari edit text
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Validasi input email dan password kosong
        if(TextUtils.isEmpty(email) &&
                TextUtils.isEmpty(password)) {
            Toast.makeText(view.getContext(), "Email dan Password tidak boleh kosong!",
                    Toast.LENGTH_LONG).show();
        }
        // Validasi input email kosong
        else if(TextUtils.isEmpty(email)){
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if(!isValidEmail(email)) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        }
        // Validasi password kosong
        else if(TextUtils.isEmpty(password)) {
            Toast.makeText(view.getContext(), "Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }else if(!(password == confirmPassword)){
            Toast.makeText(view.getContext(), "Confirm password harus sama!", Toast.LENGTH_LONG).show();
        }
        // Intent ke SuccessActivity
        else {
            Intent i = new Intent(ResetPassword.this, SuccessActivity.class);
            startActivity(i);
        }

    }

    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
