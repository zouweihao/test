package com.infragistics.samples.barcode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.infragistics.controls.QRCodeBarcodeView;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleLayout;


public class QrBarcodeSample extends SampleLayout {
    public  QrBarcodeSample(Activity activity) {
        super(activity);
        sampleContainer.setBackgroundColor(Color.WHITE);

        final QRCodeBarcodeView QRbar = new QRCodeBarcodeView(activity);
        QRbar.setBarBrush(new SolidColorBrush(Color.BLACK));
        QRbar.setLabelBrush(new SolidColorBrush(Color.BLACK));
        QRbar.setData("12345678");

        setOptions(sampleOptions, QRbar, activity);

        sampleContainer.addView(QRbar);
    }

    private void setOptions(LinearLayout sampleLayout, final QRCodeBarcodeView qrbarcode, final Activity activity)
    {

        final EditText et = new EditText(activity);
        et.setHint("Enter new barcode data");

        Button btnAdd = new Button(activity);
        btnAdd.setText("Set");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(activity, view);
                if (et.getText().length() > 0) {
                    qrbarcode.setData(et.getText().toString());
                }
            }
        });

        LinearLayout option= new LinearLayout(activity);
        option.setOrientation(LinearLayout.HORIZONTAL);
        option.addView(et);
        option.addView(btnAdd);
        sampleLayout.addView(option);
    }

    private static void hideSoftKeyboard (Activity activity, View view)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    @Override
    protected String getDescription() {
        return "QR (Quick Response) Code Barcode can be used in commercial tracking, entertainment and transport ticketing, product marketing applications.";
    }
}
