package cnpm.com.ires.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cnpm.com.ires.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtUserName;
    private TextView txtPassword;
    private ImageView imgIResAvatar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "cnpm.com.ires",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        init();
    }

    private void init() {
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtUserName = (TextView) findViewById(R.id.txtUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        imgIResAvatar = (ImageView) findViewById(R.id.imgIResAvatar);
        btnLogin.setOnClickListener(this);
    }

    private boolean isChecked() {
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.w("onClick", v.getId() + "  " + R.id.btnLogin);
        if (v.getId() == R.id.btnLogin) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
